import React, { useState } from 'react';
import axios from 'axios';
import { Navigate } from 'react-router-dom'; // Import useParams, useHistory, and Navigate hooks

const AddLect = () => {
    const [id, setId] = useState('');
    const [name, setName] = useState('');
    const [credit, setCredit] = useState('');
    const [submitted, setSubmitted] = useState(false); // State to track whether form is submitted successfully
  
    const handleSubmit = async (e) => {
      e.preventDefault(); 
  
      try {
        const lectData = {
          id: id,
          name: name,
          credit: credit
        };
    
        await axios.post(`http://localhost:8080/newLect`, lectData);
    
        // If successful, set submitted to true
        setSubmitted(true);
      } catch (error) {
        console.log(error);
      }
    }
    // If form is submitted successfully, navigate to main page
    if (submitted) {
      return <Navigate to="/lectures" replace={true} />;
    }
  
    return (
      <div className='text-center w-1/2'>
        <h2 className='text-2xl font-sans font-semibold mt-3'>Add Lecture</h2>
        <form className='m-5 flex flex-col gap-3' onSubmit={handleSubmit}>
          <input
            type='text'
            placeholder='Id'
            className='p-3 border-2'
            value={id}
            onChange={(e) => setId(e.target.value)}
          />
          <input
            type='text'
            placeholder='Name'
            className='p-3 border-2'
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <input
            type='text'
            placeholder='Credit'
            className='p-3 border-2'
            value={credit}
            onChange={(e) => setCredit(e.target.value)}
          />
          <button type="submit" className='self-end p-3 ps-6 pe-6 border-2'>Submit</button>
        </form>
      </div>
    );
}

export default AddLect