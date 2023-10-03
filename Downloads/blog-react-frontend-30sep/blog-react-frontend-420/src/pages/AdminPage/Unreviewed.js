import { Link, useNavigate } from "react-router-dom";
import "../../Assets/Styles/Unreviewed.css";
import { RxDashboard } from "react-icons/rx";
import { BsFillRCircleFill } from "react-icons/bs";
import { FaRegFlag } from "react-icons/fa";
import { AiOutlineDown } from "react-icons/ai";
import { GrBlog } from "react-icons/gr";
import React, { useEffect, useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";
//import { AdminUnreviwed , FilterTitle } from "../../Services/AdminPostService";
import AdminCard from "../../Component/ReusableComponent/AdminCard";
const Unreviewed = () => {
  const [data, setData] = useState([]);
  const [userLoggedIn, setUserLoggedIn] = useState(false);
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedTechnology, setSelectedTechnology] = useState("ALL");
  const [likecount, setlikeCount] = useState([]);
  const cardName = "UNREVIEWED";
  const userJSON = localStorage.getItem("user");
  const user = JSON.parse(userJSON);

  const navigate = useNavigate();
  useEffect(() => {
    const fetchData = async () => {
      const payload = {
        technology: selectedTechnology,
        title: searchTerm,
        userId: user.userId,
      };
      try {
        const response = await axios.post(
          "http://localhost:8080/posts/unReviewed",
          payload
        );
        setData(response.data);
        console.log(response.data);
      } catch (error) {
        console.error(error);
        toast.error("Fetch failed");
      }
    };
    fetchData();
  }, [searchTerm, selectedTechnology]);

  const handleTechnologyChange = (event) => {
    setSelectedTechnology(event.target.value);
  };

  const handleLogout = () => {
    setUserLoggedIn(false);
    navigate("/login");
  };
  return (
    <>
      <div className="sidebar5">
        <h1 className="company5">
          <b style={{ color: "orange" }}>Blog</b>
          <b>Portal</b>
        </h1>
        <div>
          <p className="dash5 OnSelection5">
            <RxDashboard /> Unreviewed
          </p>
          <p className="dash5">
            <Link className="rmvLine5" to="/report">
              <FaRegFlag /> Reported Blogs
            </Link>
          </p>
        </div>
        <button className="log5" onClick={handleLogout}>
          Log Out
        </button>
      </div>
      <div className="headbar5">
        <div className="navbar5">
          <input
            type="search"
            placeholder="search blogs"
            className="find5"
            onChange={(e) => {
              const timer = setTimeout(() => {
                setSearchTerm(e.target.value);
              }, 1300);
              return () => clearTimeout(timer);
            }}
          />
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
          <BsFillRCircleFill className="logoAcc5" />
          <AiOutlineDown />
        </div>
        {data?.map((item) => (
          <AdminCard
            key={item.id}
            date={item.createdDate}
            fullname={item.fullname}
            designation={item.designation}
            technology={item.technology}
            title={item.title}
            content={item.content}
            isCard={cardName}
          />
        ))}
      </div>
    </>
  );
};
export default Unreviewed;
