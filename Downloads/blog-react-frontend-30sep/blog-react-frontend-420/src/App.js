import { Routes, Route } from "react-router-dom";
import WritePostBlog from "./pages/EmployeePage/WritePostBlog";
import { useEffect, useState } from "react";
import Dashboard from "./pages/EmployeePage/Dashboard";
import MyBlog from "./pages/EmployeePage/MyBlog";
import Registration from "./pages/Registration";
import Login from "./pages/Login";
import EditBlog from "./pages/EmployeePage/EditBlog";
import Unreviewed from "./pages/AdminPage/Unreviewed";
import Reported from "./pages/AdminPage/Reported";
import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';
function App() {
  //  const y = localStorage.getItem( JSON.parse("user"));
  const [userLoggedIn, setUserLoggedIn] = useState({});
  useEffect(() => {
    setUserLoggedIn(JSON.parse(localStorage.getItem("user")));
  }, [setUserLoggedIn]);
  return (
    <>
    <ToastContainer/>
    <Routes>
      <Route path="/" element={<Registration />} />
      <Route path="login" element={<Login setUserLoggedIn={setUserLoggedIn} />} />

      {userLoggedIn && (
        <>
          {userLoggedIn?.role === "ADMIN" ? (
            <>
              <Route path="/unreviewed" element={<Unreviewed />} />
             
              <Route path="/report" element={<Reported />} />
            </>
          ) : (
            <>
              <Route path="/dashboard" element={<Dashboard />} />
              <Route path="/write" element={<WritePostBlog />} />
              <Route path="/edit/:id" element={<EditBlog />} />
              <Route path="/blog" element={<MyBlog />} />
            </>
          )}
        </>
      )}

      {/* {!userLoggedIn && (
        <>
          <Route path="/*" element={<Error />} />
        </>
      )} */}
    </Routes>
    </>
  );
}

export default App;



