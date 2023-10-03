import React from "react";
import  { useState } from "react";
import "../../Assets/Styles/EmployeeCard.css";
import parse from "html-react-parser";
import { BiLike } from "react-icons/bi";
import { AiOutlineDislike } from "react-icons/ai";
import { AiOutlineUser } from "react-icons/ai";
import { SiCodesignal } from "react-icons/si";
import { MdOutlineDateRange } from "react-icons/md";
import { GrTechnology } from "react-icons/gr";
import { TbFlag3 } from "react-icons/tb";
import { LuSendHorizonal } from "react-icons/lu";
import {commentBlog, dislikeBlog, reportBlog, likeBlog} from "../../Services/ReportedPostService"
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
const EmployeeCard = (props) => {
    const [showComments, setShowComments] = useState(false);
    const [isLiked, setisLiked] = useState(false);
    const [isDisliked, setisDisliked] = useState(false);
    const [isReport, setisReport] = useState(false);
    const [allComment, setAllComment] = useState([]);
    const [usercomment, setUserComment] = useState("");
    const [likecount, setlikecount] = useState(props.likecount1);
    const [dislikecount, setdislikecount] = useState(props.dislikecount1);
    const [reportcount, setreportcount] = useState(props.reportcount1);


  
    const handleUserCommentChange = (e) => {
      setUserComment(e.target.value);
    };

    const handleLikeClick = async(postId, userId) => {
      isLiked ? setisLiked(false) : setisLiked(true);
      const payload = {
        postId: postId,
        userId: userId,
      };
        const response=await likeBlog(payload);
        setlikecount(response?.data.like)
        setdislikecount(response.data.dislike)
    };

    const handleDislikeClick = async (postId, userId) => {
      isDisliked ? setisDisliked(false) : setisDisliked(true);
      const payload = {
        postId: postId,
        userId: userId,
  
      };
        const response=await dislikeBlog(payload);
        setdislikecount(response.data.dislike)
        setlikecount(response.data.like)
    };
  
    const handleReportClick = async (postId, userId) => {
      isReport ? setisReport(false) : setisReport(true);
      const payload = {
        postId: postId,
        userId: userId,
      };
      const response=await reportBlog(payload)
      setreportcount(response.data.reportedCountsOnPost);
    };
   
    const handleUserCommentSubmit = async (postId, userId) => {
      const trimmedComment = usercomment ? usercomment.trim() : "";
      if(trimmedComment.length === 0) {
        toast.error("Comment should not be blank");
      }
      if(trimmedComment.length!==0)
      {
        const data = {
          postId: postId,
          userId: userId,
          comment: usercomment,
        
        };
        const response = await commentBlog(data)
        setAllComment(response.data);
    };
    }
    const navigate = useNavigate();
    const handleApproveClick = (id) => {
      navigate(`/edit/${id}`);
    };
    const handleShowCommentsClick = () => {
      setShowComments(true);
    };
  return (
    <>
      <div className="part2">
      <div className="cont3">
      <div className="cont01">
        <h1>{props.title}</h1>
      </div>
     {props.showButton===true? <div className="cont4">
     {props.isStatus === "APPROVED" ? (
  <button className="status1">APPROVED</button>
) : props.isStatus === "REJECTED" ? (
  <button className="status3">REJECTED</button>
) : (
  <button className="status2">PENDING</button>
)}
          <button
            className="editbtn"
            onClick={() => handleApproveClick(props.postId)}
          >
            Edit
          </button>
        </div> : <div></div>
   }
        </div>
      <div className="cont10">
        <h3>
          <AiOutlineUser />
          {props.fullname}
        </h3>
        <h3>
          <SiCodesignal />
          {props.designation}
        </h3>
        <h3>
          <GrTechnology />
          {props.technology}
        </h3>
        <h3>
          <MdOutlineDateRange />
          Post Date:{props.date}
        </h3>
      </div>
      <p>{parse(props.content)}</p>

      <br></br>
      <div className="cont12">
        <div className="add-comment-box">
          <input
            type="search"
            placeholder="Comments here"
            className="commnt7"
            onChange={handleUserCommentChange}
          ></input>
          <div
            className="submitBtn"
            onClick={() => handleUserCommentSubmit(props.postId, props.userId)}
          >
            <LuSendHorizonal className="arrIcon" />
          </div>
        </div>
        <div className="cont7">
        <button
            className={`like ${isLiked ? "active" : ""}`}
            onClick={() => handleLikeClick(props.postId, props.userId, props.like)}
          >
            <b className="actions">
              <BiLike className="likeIcon" />
              Like({likecount})
            </b>
          </button>
          <button
            className={`like ${isDisliked ? "active" : ""}`}
            onClick={() => handleDislikeClick(props.postId, props.userId,)}
          > <b className="actions">
              <AiOutlineDislike className="likeIcon" />
              Dislike({dislikecount})
            </b>
          </button>
          <button
            className={`like ${isReport ? "active" : ""}`}
            onClick={() => handleReportClick(props.postId, props.userId)}
          >
             <b className="actions">
              <TbFlag3 className="likeIcon" />
              Report({reportcount})
            </b>
          </button>
        </div>
      </div>
      <button className="showComment" onClick={handleShowCommentsClick}>
        <b>Show Comments</b>
      </button>
      {Object.keys(allComment).map((key) => (
        <div key={key}>
          <h3>{key}</h3>
          <ul>
            {allComment[key].map((item, index) => (
              <li key={index}>{item}</li>
            ))}
          </ul>
        </div>
      ))}
    </div>
    </>
  );
};
export default EmployeeCard;