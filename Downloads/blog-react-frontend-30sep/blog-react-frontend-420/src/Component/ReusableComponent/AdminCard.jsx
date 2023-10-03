import React, { useState } from "react";
import "../../Assets/Styles/AdminCard.css";
import parse from "html-react-parser";
import { AiOutlineUser } from "react-icons/ai";
import { SiCodesignal } from "react-icons/si";
import { MdOutlineDateRange } from "react-icons/md";
import { GrTechnology } from "react-icons/gr";
import axios from "axios";
import Button from "./../ReusableComponent/Button";
import { toast } from "react-toastify";
const AdminCard = (props) => {
  const [responseData, setResponseData] = useState();
  const [isActionDone, setIsActionDone] = useState(false);
  const userJSON = localStorage.getItem("user");
    const user = JSON.parse(userJSON);
  const handleApproveClick = async (postId, userId) => {
    console.log("handleApproveClick called");
    const payload = {
      postId: postId,
      user: user.userId,
    };
    try {
      const response = await axios.put(
        `http://localhost:8080/posts/${postId}/${userId}/review?status=APPROVED`,
        payload
      );
      setResponseData(response.data);
      toast.success("Approval successful");
      setIsActionDone(true);
    } catch (error) {
      console.error(error);
      toast.error("Approval failed");
    }
  };

  const handleRejectClick = async (postId, userId) => {
    // isReport ? setisReport(false) : setisReport(true);
    const payload = {
      postId: postId,
      userId: useruserId,
    };
    try {
      const response = await axios.put(
        "http://localhost:8080/posts/${postId}/${userId}/review?status=REJECTED",
        payload
      );
      setResponseData(response.data);
      toast.success("rejected successful");
      setIsActionDone(true);
    } catch (error) {
      console.error(error);
      toast.error("rejection failed");
    }
  };
  const handleIgnoreClick = async (postId, userId) => {
    console.log(postId);
    console.log(userId);
    const payload = {
      postId: postId,
      userId: userId,
    };
    try {
      const response = await axios.put(
        "http://localhost:8080/posts/report-blog-ignore",
        payload
      );
      setResponseData(response.data);
      toast.success("Ignore successful");
      setIsActionDone(true);
    } catch (error) {
      console.error(error);
      toast.error("ignore failed");
    }
  };

  const handleDeleteClick = async (postId, userId) => {
    console.log("handleDeleteClick called");

    const payload = {
      postId: postId,
      userId: userId,
    };
    try {
      const response = await axios.delete(
        "http://localhost:8080/posts/delete/${postId}",
        payload
      );
      setResponseData(response.data);
      alert("Deleted successful");
      setIsActionDone(true);
    } catch (error) {
      console.error(error);
      alert("Deleted failed");
    }
  };

  if (isActionDone) {
    return null;
  }
  return (
    <div className="part2">
      <div className="cont01">
        <h1>{props.title}</h1>
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
      {props.isCard == "UNREVIEWED" ? (
        <div>
          <Button
            buttonName="Approve"
            select={() => handleApproveClick(props.postId, props.userId)}
            className="approveBtn"
          />
          <Button
            buttonName="Reject"
            select={() => handleRejectClick(props.postId, props.userId)}
            className="rejectBtn"
          />
        </div>
      ) : (
        
        <div>
          <Button
            buttonName="Ignore"
            select={() => handleIgnoreClick(props.postId, props.userId)}
            className="ignoreBtn"
          />
          <Button
            buttonName="Delete"
            select={() => handleDeleteClick(props.postId, props.userId)}
            className="deleteBtn"
          />
        </div>
      )}
    </div>
  );
};
export default AdminCard;
