import React from 'react'
import { Link } from "react-router-dom";
import { ImCross } from "react-icons/im";

const DeleteButton = ({id,link}) => {
  return (
    <Link to={`${link}${id}`}>
        <button className='rounded-full border-2 bg-red-700 p-1'>
            <ImCross />
        </button>
    </Link>
  )
}

export default DeleteButton