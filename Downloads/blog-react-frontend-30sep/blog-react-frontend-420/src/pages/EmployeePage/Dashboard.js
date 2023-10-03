import { Link, useNavigate } from "react-router-dom";
import "../../Assets/Styles/Dashboard.css";
import { RxDashboard } from "react-icons/rx";
import { BsFillRCircleFill } from "react-icons/bs";
import { FaPenFancy } from "react-icons/fa";
import { AiOutlineDown } from "react-icons/ai";
import { GrValidate } from "react-icons/gr";
import React, { useEffect, useState } from "react";
import { parse } from "html-react-parser";
import { toast } from "react-toastify";
import axios from "axios";
import EmployeeCard from "../../Component/ReusableComponent/EmployeeCard";
const Dashboard = () => {
  const [data, setData] = useState([]);
  const [userLoggedIn, setUserLoggedIn] = useState(false);
  const [selectedTechnology, setSelectedTechnology] = useState("ALL");
  const [searchTerm, setSearchTerm] = useState("");
  const userId = ""; 
  const postId = "";
  const navigate = useNavigate();
  const userJSON = localStorage.getItem("user");
  const user = JSON.parse(userJSON);

  useEffect(() => {
    const fetchData = async () => {
          const payload = {
             technology: selectedTechnology,
             title: searchTerm,
             userId: user.userId
           };
      try {
        const response = await axios.post("http://localhost:8080/posts/employee-dashboard",payload);
        setData(response.data);
        console.log(response.data);
      } catch (error) {
        console.error(error);
        toast.error("Fetch failed");
      }
    };
    fetchData();
  }, [searchTerm, selectedTechnology]);
  
    // const fetchData = async () => {
    //   const payload = {
    //     technology: selectedTechnology,
    //     title: searchTerm,
    //   };
    //   try {
    //     const response = await axios.post(
    //       "http://localhost:8080/posts/technologyTitle",
    //       payload
    //     );
    //     setData(response?.data);
    //   } catch (error) {
    //     toast.error("Fetch failed");
    //   }
    // };

  const handleTechnologyChange = (event) => {
    setSelectedTechnology(event.target.value);
  };
  const handleSearchInputChange = (event) => {
    setSearchTerm(event.target.value);
  };
  const handleLogout = () => {
    setUserLoggedIn(false);
    navigate("/login");
  };
  return (
    <>
      <div className="sidebar">
        <h1 className="company">
          <b style={{ color: "orange" }}>Blog</b>
          <b>Portal</b>
        </h1>
        <div>
          <p className="dash2 OnSelection">
            <RxDashboard /> Dashboard
          </p>
          <p className="dash2">
            <Link className="rmvLine" to="/write">
              <FaPenFancy /> Write Post Blog
            </Link>
          </p>
          <p className="dash2">
            <Link className="rmvLine" to="/blog">
              <GrValidate /> My Blog
            </Link>
          </p>
        </div>
        <button className="log" onClick={handleLogout}>
          Log Out
        </button>
      </div>
      <div className="headbar">
        <div className="navbar">
          <input
            type="search"
            placeholder="search blogs"
            className="find"
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
            className="celect"
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
          <BsFillRCircleFill className="logoAcc2" />
          <AiOutlineDown />
        </div>
        {/* {data?.map((item) =>
          (selectedTechnology === "All" || item.technology === selectedTechnology) &&
          (searchTerm === "" || item.title.toLowerCase().includes(searchTerm.toLowerCase())) &&
          item.status ? (
            <Card
              key={item.id}
              date={item.createdDate}
              fullname={item.fullname}
              designation={item.designation}
              technology={item.technology}
              title={item.title}
              content={item.content}
              userId={item.userId}
              postId={item.id}
            />
          ) : null
        )} */}
            {data?.map((item) =>
          // (selectedTechnology === "All" || item.technology === selectedTechnology) &&
          // (searchTerm === "" || item.title.toLowerCase().includes(searchTerm.toLowerCase())) &&
          // item.status ? (
            <EmployeeCard
              key={item.id}
              date={item.createdDate}
              fullname={item.fullname}
              designation={item.designation}
              technology={item.technology}
              title={item.title}
              content={item.content}
              userId={item.userId}
              postId={item.id}
              likecount1={item.likeCount}
              dislikecount1={item.dislikeCount}
              reportcount1={item.reportCount}
              commentcount1={item.commentCount}
              />
              )}
            </div>
          </>
        );
      };
export default Dashboard;
