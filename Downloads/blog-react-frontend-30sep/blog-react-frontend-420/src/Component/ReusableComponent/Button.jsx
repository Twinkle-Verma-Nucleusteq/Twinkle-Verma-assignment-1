import React from "react";
const Button = ({ buttonName, select, className }) => {
  return (
    <>
      <button type="submit" onClick={select} className={className}>
        {buttonName}
      </button>
    </>
  );
};
export default Button;