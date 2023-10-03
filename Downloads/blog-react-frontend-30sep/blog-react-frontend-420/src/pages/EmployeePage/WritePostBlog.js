import { useEffect, useRef, useState } from "react";
import "../../Assets/Styles/WritePostBlog.css";
import { RxDashboard } from "react-icons/rx";
import { BsFillRCircleFill } from "react-icons/bs";
import { FaPenFancy } from "react-icons/fa";
import { AiOutlineDown } from "react-icons/ai";
import { GrValidate } from "react-icons/gr";
import { Link, useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import JoditEditor from "jodit-react";
import { toast } from "react-toastify";
const WritePostBlog = ({ postId, initialData }) => {
  const [userLoggedIn, setUserLoggedIn] = useState(false);
  const navigate = useNavigate();
  const [selectedCategory, setSelectedCategory] = useState("");
  
  const [heading, setHeading] = useState("");
  const editor = useRef(null);
  const [content, setContent] = useState("");
  const [validationErrors, setValidationErrors] = useState({});
  const handleCategoryChange = (e) => {
    setSelectedCategory(e.target.value);
  };

  const userJSON = localStorage.getItem("user");
  const user = JSON.parse(userJSON);
  const id2 = user.userId;
  const [id1, setid] = useState(id2);
  console.log(user.userId);
  const [data, setData] = useState({
    title: "",
    content: "",
    technology: "",
    userId: id2,
  });

  const handleLogout = () => {
    setUserLoggedIn(false);
    navigate("/login");
  };

  useEffect(() => {
    if (postId && initialData) {
      setHeading(initialData.title || "");
      setSelectedCategory(initialData.technology || "");
      setContent(initialData.content || "");
      setid(postId || id2);
    }
  }, [postId, initialData]);
  const handleSubmit = async (e) => {
    e.preventDefault();
    setData({
      ...(data.title = heading),
      ...(data.content = content),
      ...(data.technology = selectedCategory),
      ...(data.userId = id1),
    });

    const errors = {};
    if (!selectedCategory) {
      errors.category = "Category is required";
      setValidationErrors(true);
    }
    if (!heading.trim()) {
      errors.heading = "Heading is required";
      setValidationErrors(true);
    }
    if (!content.trim()) {
      errors.content = "Content is required";
      setValidationErrors(true);
    }
    setValidationErrors(errors);

    if (postId) {
      try {
        const response = await axios.put(
          `http://localhost:8080/posts/${postId}`,
          data
        );
        toast.success("Blog updated successfully ");
      } catch (error) {
        toast.error("blog not updated");
      }
    } else {
      try {
        const response = await axios.post(
          `http://localhost:8080/posts/create/${id2}`,
          data
        );
        toast.success("Blog submitted successfully and pending for admin approval");
      } catch (error) {
        toast.error("Submit not successful");
      }
    }
  };
  return (
    <div className="container9">
      <div className="sidebar">
        <h1 className="company">
          <b style={{ color: "orange" }}>Blog</b>
          <b>Portal</b>
        </h1>

        <p className="dash2">
          <Link to="/dashboard" className="rmvLine">
            <RxDashboard /> Dashboard
          </Link>
        </p>
        <p to="/write" className="dash2  OnSelection">
          <FaPenFancy /> Write Post Blog
        </p>
        <p className="dash2">
          <Link to="/blog" className="rmvLine">
            <GrValidate /> My Blog
          </Link>
        </p>

        <button className="log" onClick={handleLogout}>
          {" "}
          Log Out
        </button>
      </div>

      <div className="headbar">
        <div className="navbar">
          <BsFillRCircleFill className="logoAcc" />
          <AiOutlineDown />
        </div>
        <div className="part3">
          <select
            value={selectedCategory}
            className="select2"
            onChange={handleCategoryChange}
          >
            <option value="">Select Technology</option>
            <option value="NODE_JS">NodeJs</option>
<option value="JAVA">Java</option>
<option value="BLOCKCHAIN">Blockchain</option>
<option value="DATA_SCIENCE">Data Science</option>
<option value="CLOUD_TECHNOLOGY">Cloud Technology</option>
<option value="PYTHON">Python</option>
<option value="NO_SQL">NoSQL</option>
<option value="SQL_DATABASES">SQL databases</option>
<option value="REACT_JS">ReactJs</option>
<option value="HTML">HTML</option>
<option value="MICROSERVICES">Microservices</option>
<option value="DEVOPS">DevOps</option>
<option value="BUSINESS_INTELLIGENCE">Business Intelligence</option>
<option value="OTHERS">Others</option>
          </select>
          {validationErrors.category && (
            <div className="error">{validationErrors.category}</div>
          )}
          <input
            type="text"
            className="heading-input"
            id="header"
            name="header"
            value={heading}
            onChange={(e) => setHeading(e.target.value)}
            placeholder="Heading here"
            required
          />
          {validationErrors.heading && (
            <div className="error">{validationErrors.heading}</div>
          )}
          <div className="jodit">
            <JoditEditor
              ref={editor}
              value={content}
              onChange={(newContent) => {
                setContent(newContent);
              }}
            />
          </div>
          {validationErrors.content && (
            <div className="error">{validationErrors.content}</div>
          )}
          <button
            className="Post"
            onClick={(e) => {
              handleSubmit(e);
            }}
          >
            Post
          </button>
        </div>
      </div>
    </div>
  );
};
export default WritePostBlog;
