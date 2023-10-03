import axios from "axios";

const LIKE_URL = "http://localhost:8080/posts/likes/";
export async function likeBlog(payload) {
  console.log("tinku")
  try {
    const response = await axios.put(LIKE_URL,payload);
    return response
  } catch (error) {
    console.error(error);
    alert("Like failed");
  }
}

const DISLIKE_URL = "http://localhost:8080/posts/dislikes/";
export async function dislikeBlog(payload) {
  try {
    const response = await axios.put(DISLIKE_URL,payload);
    return response
  } catch (error) {
    console.error(error);
    alert("Dislike failed");
  }
}

const REPORT_URL = "http://localhost:8080/posts/report-blog/";
export async function reportBlog(payload) {
  try {
    const response = await axios.put(REPORT_URL,payload);
    return response
  } catch (error) {
    console.error(error);
    alert("report failed");
  }
}

const COMMENT_URL = "http://localhost:8080/posts/comments/";
export async function commentBlog(payload) {
  try {
    const response = await axios.put(COMMENT_URL,payload);
    return response
  } catch (error) {
    console.error(error);
    alert("comment failed");
  }
}
