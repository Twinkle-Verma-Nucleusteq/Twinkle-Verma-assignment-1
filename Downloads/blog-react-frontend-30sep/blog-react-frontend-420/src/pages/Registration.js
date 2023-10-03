import { useState } from "react";
import "../Assets/Styles/Registration.css";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { toast } from "react-toastify";
//import "../Assets/Styles/toastStyle.css";
const Dashboard = ()=> {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    firstname: "",
    lastname: "",
    email: "",
    contactNumber: "",
    username: "",
    password: "",
    designation: "",
    confirmPassword: "",
    gender: ""
    // role:""
  });
  const [checkSubmit, setCheckSubmit] = useState(false);
  const [errors, setErrors] = useState({});
  const [selectedGenderError, setSelectedGenderError] = useState("");
  const handleSubmit = async (e) => {
    e.preventDefault();
    const newErrors = {};
    // Validate First Name
    if (!formData.firstname.trim()) {
      newErrors.firstname = "First name is required";
      setCheckSubmit(true);
    } else if (!/^[a-zA-Z]{3,}$/.test(formData.firstname)) {
      newErrors.firstname = "first name should have minimum 3 characters";
      setCheckSubmit(true);
    }
    // Validate Last Name
    if (!formData.lastname.trim()) {
      newErrors.lastname = "Last name is required";
      setCheckSubmit(true);
    } else if (!/^[a-zA-Z]{3,}$/.test(formData.lastname)) {
      newErrors.lastname = "last name should have minimum 3 characters";
      setCheckSubmit(true);
    }
    // Validate Email
    if (!formData.email.trim()) {
      newErrors.email = "Email is required";
      setCheckSubmit(true);
    } else if (!/^[\w\.-]+@nucleusteq\.com$/.test(formData.email)) {
      newErrors.email = "email should end with “nucleusteq.com” domain.";
      setCheckSubmit(true);
    }

    const passwordRegex= /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,10}$/;
    // Validate Contact Number
    if (!formData.contactNumber.trim()) {
      newErrors.contactNumber = "Contact number is required";
      setCheckSubmit(true);
    } else if (!/^(\+91)?\d{10}$/.test(formData.contactNumber)) {
      newErrors.contactNumber =
        "Mobile number should be of 10 digits and country code should be “+91”";
      setCheckSubmit(true);
    }
    // Validate Username
    if (!formData.username.trim()) {
     newErrors.username = "Username is required";
      setCheckSubmit(true);
    } else if (!/^[a-zA-Z]{3,}$/.test(formData.username)) {
      newErrors.username = "User name should have minimum 3 characters";
      setCheckSubmit(true);
    }
    // Validate Designation
    if (!formData.designation.trim()) {
      newErrors.designation = "Designation is required";
      setCheckSubmit(true);
    } else if (
      ![
        "Intern",
        "Software Engineer",
        "Senior Software Engineer",
        "Technical Lead",
        "Architect",
        "Senior Architect",
        "Delivery Head",
        "Department Head",
        "HR",
        "Others",
      ].includes(formData.designation)
    ) {
      newErrors.designation = "Invalid designation";
      setCheckSubmit(true);
    }
    // if (!formData.role.trim()) {
    //   newErrors.role = "Role is required";
    //   setCheckSubmit(true);
    // } else if (
    //   ![
    //     "ADMIN",
    //     "EMPLOYEE"
    //   ].includes(formData.role)
    // ) {
    //   newErrors.role = "Invalid role";
    //   setCheckSubmit(true);
    // }
    // Validate Password
    if (!formData.password.trim()) {
      newErrors.password = "Password is required";
      setCheckSubmit(true);
    } else if (!passwordRegex.test(formData.password)) {
      newErrors.password = "Password should meet the criteria: 8-10 characters, at least one lowercase letter, one uppercase letter, one digit, and one special character (@$!%*?&)";
      setCheckSubmit(true);
    }
    
    
    // Validate Confirm Password
    if (!formData.confirmPassword.trim()) {
      newErrors.confirmPassword = "Confirm password is required";
      setCheckSubmit(true);
    } else if (formData.confirmPassword !== formData.password) {
      newErrors.confirmPassword = "Passwords do not match";
      setCheckSubmit(true);
    }

    // Validate Gender
    if (!formData.gender) {
      newErrors.gender = "Please select a gender";
      setSelectedGenderError("Please select a gender");
      setCheckSubmit(true);
    } else {
      setSelectedGenderError("");
    }
    // Set the errors object and check for submission
    setErrors(newErrors);

    const hasValidationErrors = Object.keys(newErrors).length !== 0;
    setCheckSubmit(hasValidationErrors);

    if (Object.keys(newErrors).length === 0) {
      const passwordEncode=btoa(formData.password);
      const user={...formData,password:passwordEncode}
      
      try {
        // Make an HTTP POST request to your server to register the user
        const response = await axios.post(
          "http://localhost:8080/users/create",
          user
        );
        toast.success("Register successfully");
        navigate("/login");
      } catch (error) {
        toast.error("Registration not successful");
      }
    }
  };

  return (
    <div className="body1">
      <div className="container">
        <div className="title">Registration</div>
        <div className="content">
          <form onSubmit={handleSubmit}>
            <div className="user-details">
              <div className="input-box">
                <span className="details">First name</span>
                <input
                  type="text"
                  placeholder="Enter your name"
                  value={formData.firstname}
                  onChange={(e) => {
                    setFormData({ ...formData, firstname: e.target.value });
                  }}
                />
                {checkSubmit && (
                  <span className="validation">{errors.firstname}</span>
                )}
              </div>
              <div className="input-box">
                <span className="details">Last name</span>
                <input
                  type="text"
                  placeholder="Enter your lastname"
                  value={formData.lastname}
                  onChange={(e) => {
                    setFormData({ ...formData, lastname: e.target.value });
                  }}
                />
                {checkSubmit && (
                  <span className="validation">{errors.lastname}</span>
                )}
              </div>
              <div className="input-box">
                <span className="details">User name</span>
                <input
                  type="text"
                  placeholder="Enter your username"
                  value={formData.username}
                  onChange={(e) => {
                    setFormData({ ...formData, username: e.target.value });
                  }}
                />
                {checkSubmit && (
                  <span className="validation">{errors.username}</span>
                )}
              </div>
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
                <span className="details">Phone Number</span>
                <input
                  type="text"
                  placeholder="Enter your number"
                  value={formData.contactNumber}
                  onChange={(e) => {
                    setFormData({ ...formData, contactNumber: e.target.value });
                  }}
                />
                {checkSubmit && (
                  <span className="validation">{errors.contactNumber}</span>
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
              <div className="input-box">
                <span className="details">Confirm Password</span>
                <input
                  type="password"
                  placeholder="Confirm your password"
                  value={formData.confirmPassword}
                  onChange={(e) => {
                    setFormData({
                      ...formData,
                      confirmPassword: e.target.value,
                    });
                  }}
                />
                {checkSubmit && (
                  <span className="validation"> {errors.confirmPassword}</span>
                )}
              </div>
              <div className="input-box">
                <span className="details">Designation</span>
                <select
                  style={{}}
                  onChange={(e) => {
                    setFormData({ ...formData, designation: e.target.value });
                  }}
                >
                  {[
                    { key: "--Select Designation--", value: "" },
                    { key: "Intern", value: "Intern" },
                    { key: "Software Engineer", value: "Software Engineer" },
                    {
                      key: "Senior Software Engineer",
                      value: "Senior Software Engineer",
                    },
                    { key: "Technical Lead", value: "Technical Lead" },
                    { key: "Architect", value: "Architect" },
                    { key: "Senior Architect", value: "Senior Architect" },
                    { key: "Delivery Head", value: "Delivery Head" },
                    { key: "Department Head", value: "Department Head" },
                    { key: "HR", value: "HR" },
                    { key: "Others", value: "Others" },
                  ].map((e) => {
                    return <option value={e?.value}>{e?.key}</option>;
                  })}
                </select>
                {checkSubmit && (
                  <span className="validation"> {errors.designation}</span>
                )}
              </div>
            </div>
            {/* <div className="input-box">
                <span className="details">Role</span>
                <select
                  style={{}}
                  onChange={(e) => {
                    setFormData({ ...formData, role: e.target.value });
                  }}
                >
                  {[
                    { key: "--Select Role--", value: "" },
                    { key: "ADMIN", value: "ADMIN" },
                    { key: "EMPLOYEE", value: "EMPLOYEE" }
                  ].map((e) => {
                    return <option value={e?.value}>{e?.key}</option>;
                  })}
                </select>
                {checkSubmit && (
                  <span className="validation"> {errors.role}</span>
                )}
              </div> 
             */}


            <div className="gender-details">
              <span className="gender-title">Gender</span>
              <div className="category">
                <label for="dot-1">
                  <input
                    type="radio"
                    id="dot-1"
                    name="gender"
                    value="Male"
                    onChange={(e) => {
                      setFormData({ ...formData, gender: e.target.value });
                    }}
                  />
                  <span className="gender">Male</span>
                </label>
                <label for="dot-2">
                  <input
                    type="radio"
                    id="dot-2"
                    name="gender"
                    value="Female"
                    onChange={(e) => {
                      setFormData({ ...formData, gender: e.target.value });
                    }}
                  />
                  <span className="gender">Female</span>
                </label>
                <label for="dot-3">
                  <input
                    type="radio"
                    id="dot-3"
                    name="gender"
                    value="Other"
                    // checked={formData.gender === "Other"}
                    onChange={(e) => {
                      setFormData({ ...formData, gender: e.target.value });
                    }}
                  />
                  <span className="gender">Other</span>
                </label>
              </div>
              {checkSubmit && (
                <span className="validation">{selectedGenderError}</span>
              )}
            </div>
            <div className="button">
              <input type="submit" value="Register" />
            </div>
            <Link to="/login" className="linkPage">
              Aready have an account?
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
};
export default Dashboard;
