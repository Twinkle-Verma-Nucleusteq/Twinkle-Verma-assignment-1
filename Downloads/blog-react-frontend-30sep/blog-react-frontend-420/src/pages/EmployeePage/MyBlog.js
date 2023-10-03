import React, { useState, useEffect } from "react";
import "../../Assets/Styles/MyBlog.css";
import { RxDashboard } from "react-icons/rx";
import { BsFillRCircleFill } from "react-icons/bs";
import { FaPenFancy } from "react-icons/fa";
import { AiOutlineDown } from "react-icons/ai";
import { GrValidate } from "react-icons/gr";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { reportBlog } from "../../Services/ReportedPostService";
import { toast } from "react-toastify";
import EmployeeCard from "../../Component/ReusableComponent/EmployeeCard";
import { getCurrentUserDetails } from "../../Authentication/auth";
const MyBlog = () => {
  const [userLoggedIn, setUserLoggedIn] = useState(false);
  const [selectedTechnology, setSelectedTechnology] = useState("ALL");
  const [newComment, setNewComment] = useState("");
  const [selectedStatus, setSelectedStatus] = useState("STATUS");
  const [searchTerm, setSearchTerm] = useState("");
  const [allComment , setAllComment] = useState([]);
  const userId = ""; // Your user ID
  const postId = "";
  const navigate = useNavigate();
  const currentUser = getCurrentUserDetails();
  console.log(currentUser.userId);

  const handleLogout = () => {
    setUserLoggedIn(false);
    navigate("/login");
  };

  const handleTechnologyChange = (event) => {
    setSelectedTechnology(event.target.value);
  };
  const handleStatusChange = (event) => {
    setSelectedStatus(event.target.value);
  };
  // const handleSearchInputChange = (event) => {
  //   setSearchTerm(event.target.value);
  // };

  const [blogData, setBlogData] = useState([]);

  // const userID=localStorage.getItem("user", JSON.stringify("user"));
  // console.log(userID,"hii")
  const userJSON = localStorage.getItem("user");
  const user = JSON.parse(userJSON);
  useEffect(() => {
    const fetchData = async () => {
          const payload = {
             technology: selectedTechnology,
             title: searchTerm,
             status: selectedStatus,
             userId: user.userId
           };
      try {
        const response = await axios.post("http://localhost:8080/posts/employee-my-blog",payload);
        setBlogData(response.data);
        console.log(response.data);
      } catch (error) {
        console.error(error);
        toast.error("Fetch failed");
      }
    };
    fetchData();
  }, [searchTerm, selectedTechnology,selectedStatus]);

  
  return (
    <>
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
        <p className="dash2">
          <Link to="/write" className="rmvLine">
            <FaPenFancy /> Write Post Blog
          </Link>
        </p>
        <p className="dash2 OnSelection">
          <GrValidate /> My Blog
        </p>

        <button className="log" onClick={handleLogout}>
          Log Out
        </button>
      </div>

      <div className="headbar">
        <div className="navbar3">
          <input
            type="search"
            placeholder="search blogs"
            className="find3"
            onChange={(e) => {
              const timer = setTimeout(() => {
                setSearchTerm(e.target.value);
              }, 1300);
              return () => clearTimeout(timer);
            }}
          ></input>
          <select
            id="technology"
            name="technology"
            className="celect3"
            value={selectedTechnology}
            onChange={handleTechnologyChange}
          >
            <option value="ALL">All</option>
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

          <select
            id="status"
            name="status"
            className="celect3"
            value={selectedStatus}
            onChange={handleStatusChange}
          >
             <option value="STATUS">Status</option> 
            <option value="APPROVED">Approve</option>
            <option value="REJECTED">Rejection</option>
            <option value="PENDING">pending</option>
          </select>
          <BsFillRCircleFill className="logoAcc3" />
          <AiOutlineDown />
        </div>
        <div className="empty"></div>

       
          {blogData?.map((item) =>
                     <EmployeeCard
              key={item.id}
              date={item.createdDate}
              fullname={item.fullname}
              designation={item.designation}
              technology={item.technology}
              title={item.title}
              content={item.content}
              postId={item.id}
              userId={user.userId}
              isStatus={item.status}
              isLiked={item.isLiked}
              isDisliked={item.isDisliked}
              newComment={item.newComment}
              // onLike={() => handleLike(postId,userId)}
              onDislike={() => handleDislike(item.id)}
              onComment={(comment) => handleComment(item.id, comment)}
              onReport={() => handleReport(item.id)}
              allComment={allComment}
              likecount1={item.likeCount}
              dislikecount1={item.dislikeCount}
              reportcount1={item.reportCount}
              commentcount1={item.commentCount}
              showButton={true}
            />
        )}
      </div>
    </>
  );
};

export default MyBlog;
