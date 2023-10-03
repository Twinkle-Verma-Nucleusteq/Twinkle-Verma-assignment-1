 import axios from "axios";
// const UNREVIWED_URL = "http://localhost:8080/posts/unReviewed";
// export async function AdminUnreviwed(payload) {
//   try {
//     const response = await axios.get(UNREVIWED_URL,payload);
//     return response
//   } catch (error) {
//     console.error(error);
//     alert("unreview failed");
//   }
// }
const AdminReported_URL = "http://localhost:8080/posts/get-all-reported-blog";
export async function AdminReported() {
  try {
    const response = await axios.get(AdminReported_URL);
    return response
  } catch (error) {
    console.error(error);
    alert("reported failed");
  }
}
