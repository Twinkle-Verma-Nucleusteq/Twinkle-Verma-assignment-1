export const doLogin = (data,next) =>{
    localStorage.setItem("data",JSON.stringify(data));
    next()
};
export const isLoggedIn =()=>{
    let user = localStorage.getItem("user");
    if(user == null){
        return false;
    }else{
        return true;
    }
};
export const doLogout =(next)=>{
    localStorage.removeItem("data");
    next()
}
export const getCurrentUserDetails = () =>{
    if(isLoggedIn()){
        return JSON.parse(localStorage.getItem("user"));
    }else{
        return undefined;
    }
}







