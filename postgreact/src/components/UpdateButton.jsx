import React from 'react'
import { FaPlus } from "react-icons/fa";
import { Link } from "react-router-dom";

const UpdateButton = ({id, link}) => {
  return (
    <Link to={`${link}${id}`}>
        <button className='border-2 rounded-full p-1 bg-green-700'>
            <FaPlus />
        </button>
    </Link>
  )
}

export default UpdateButton