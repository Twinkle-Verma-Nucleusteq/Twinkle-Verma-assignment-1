import { useEffect, useState } from "react";
import "../Assets/Styles/Login.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";

const Login = ({ setUserLoggedIn }) => {
  const y = localStorage.getItem("user");
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  const [checkSubmit, setCheckSubmit] = useState(false);
  const [errors, setErrors] = useState({});
  const [userAdmin, setUserAdmin] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newErrors = {};

    if (!formData.email.trim()) {
      newErrors.email = "Email is required";
      setCheckSubmit(true);
    } else if (!/^[\w\.-]+@nucleusteq\.com$/.test(formData.email)) {
      newErrors.email = "Email should end with “nucleusteq.com” domain.";
      setCheckSubmit(true);
    }

    if (!formData.password.trim()) {
      newErrors.password = "Password is required";
      setCheckSubmit(true);
    }

    setErrors(newErrors);

    const hasValidationErrors = Object.keys(newErrors).length !== 0;
    setCheckSubmit(hasValidationErrors);

    if (!hasValidationErrors) {
      const passwordEncode = btoa(formData.password);
      const user = { ...formData, password: passwordEncode };
      try {
        console.log("passwordEncode");
        const response = await axios.post(
          "http://localhost:8080/users/login",
          user
        );

        setUserAdmin(response.data.role);

        localStorage.setItem("user", JSON.stringify(response.data));
        setUserLoggedIn(JSON.parse(localStorage.getItem("user")));

        if (response.data.role === "ADMIN") {
          navigate("/unreviewed");
          toast.success("Login successful");
        } else if (response.data.role === "EMPLOYEE") {
          navigate("/dashboard");
          toast.success("Login successful");
        }
      } catch (error) {
        toast.error("Login failed....");
      }
    }
  };

  return (
    <div className="body1">
      <div className="container2">
        <div className="title">Login</div>
        <div className="content">
          <form onSubmit={handleSubmit}>
            <div className="user-details2">
              <div className="input-box">
                <span className="details">Email</span>
                <input
                  type="text"
                  placeholder="Enter your email"
                  value={formData.email}
                  onChange={(e) => {
                    setFormData({ ...formData, email: e.target.value });
                  }}
                />
                {checkSubmit && (
                  <span className="validation">{errors.email}</span>
                )}
              </div>
              <div className="input-box">
                <span className="details">Password</span>
                <input
                  type="password"
                  placeholder="Enter your password"
                  value={formData.password}
                  onChange={(e) => {
                    setFormData({ ...formData, password: e.target.value });
                  }}
                />
                {checkSubmit && (
                  <span className="validation">{errors.password}</span>
                )}
              </div>
            </div>
            <div className="button">
              <input type="submit" value="Login" />
            </div>
            <Link to="/" className="linkPage">
              Create a new account?
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
