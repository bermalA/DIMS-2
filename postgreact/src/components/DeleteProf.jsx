import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, Navigate } from 'react-router-dom'; // Import useParams and Navigate hooks

const DeleteProf = () => {
  const { id } = useParams(); // Get id from URL parameters
  const [submitted, setSubmitted] = useState(false); // State to track whether form is submitted successfully

  useEffect(() => {
    const deleteData = async () => {
      try {
        // Make DELETE request
        await axios.delete(`http://localhost:8080/delete/${id}`);

        // If successful, set submitted to true
        setSubmitted(true);
      } catch (error) {
        console.log(error);
      }
    };

    deleteData();
  }, [id]);

  if (submitted) {
    return <Navigate to="/" replace={true} />;
  }

  return null; 
};

export default DeleteProf;
