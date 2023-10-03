import { Link, useNavigate } from "react-router-dom";
import "../../Assets/Styles/Reported.css";
import { RxDashboard } from "react-icons/rx";
import { BsFillRCircleFill } from "react-icons/bs";
import { FaRegFlag } from "react-icons/fa";
import { AiOutlineDown } from "react-icons/ai";
import { GrBlog } from "react-icons/gr";
import React, { useEffect, useState } from "react";
import axios from "axios";
import {
  AdminReported
} from "../../Services/AdminPostService";
import AdminCard from "../../Component/ReusableComponent/AdminCard";
const Reported = () => {
  const [data, setData] = useState([]);
  const [userLoggedIn, setUserLoggedIn] = useState(false);
  const navigate = useNavigate();
  const cardName='REPORTED';
  const userJSON = localStorage.getItem("user");
  const user = JSON.parse(userJSON);
  useEffect(() => {
    const fetchData = async () => {
      const response = await  AdminReported();
      console.log(response.data);
      setData(response.data);
    };
    fetchData(); 
  }, []);

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
          <p className="dash5 ">
          <Link className="rmvLine5" to="/unreviewed">
            <RxDashboard /> Unreviewed
            </Link>
          </p>
          <p className="dash5 OnSelection5">
              <FaRegFlag /> Reported Blogs
          </p>
        </div>
        <button className="log5" onClick={handleLogout}>
          Log Out
        </button>
      </div>
      <div className="headbar5">
        <div className="navbar5">
          <BsFillRCircleFill className="logoAcc6" />
          <AiOutlineDown />
        </div>
        {data?.map((item) =>
          !item.approved ? (
            <AdminCard
              key={item.id}
              date={item.createdDate}
              fullname={item.fullname}
              designation={item.designation}
              technology={item.technology}
              title={item.title}
              content={item.content}
              postId={item.id}
              userId={user.userId}
              isCard={cardName}
            />
          ) : null
        )}
      </div>
    </>
  );
};
export default Reported;
