import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import WritePostBlog from "./WritePostBlog";
import axios from "axios";

const EditBlog = () => {
  const { id } = useParams();
  const [blogData, setBlogData] = useState({});
  useEffect(() => {
    if (id) {
      const fetchData = async () => {
        try {
          const response = await axios.get(`http://localhost:8080/posts/${id}`);
          setBlogData(response.data);
        } catch (error) {
          alert("Fetch failed");
        }
      };

      fetchData();
    }
  }, [id]);

  return <WritePostBlog postId={id} initialData={blogData} />;
};
export default EditBlog;
