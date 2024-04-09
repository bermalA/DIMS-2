import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import UpdateButton from './UpdateButton';
import DeleteButton from './DeleteButton';
import axios from 'axios';

const Lectures = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
          try {
            const response = await axios.get('http://localhost:8080/lects'); 
            setData(response.data); 
          } catch (error) {
            console.error('Error fetching data:', error);
          }
        };
    
        fetchData();
        return () => {
          setData([]); // Reset data when component unmounts
        };
      }, []);
    
  return (
    <div className='flex flex-col m-5'>
      <div className="flex w-full">
        <h1 className='self-start w-5/6 text-2xl'>Lectures</h1>
        <div className='w-1/6 flex justify-end'>
          <Link to="/">
            <button>Professors</button>
          </Link>
        </div>
      </div>
      <Link to="/addLecture">
        <button className='w-full p-2 border-b-0 
        border-2 bg-blue-600'>
          ADD
        </button>
      </Link>
      <table className="w-full table-fixed">
        <thead>
          <tr className='border-2'>
            <th className='p-3'>Id</th>
            <th>Name</th>
            <th>Credit</th>
            <th>More</th>
          </tr>
        </thead>
        <tbody>
          {data.map(item => (
            <tr key={item.id} className="text-center border-2">
              <td className='p-3'>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.credit}</td>
              <td className='flex gap-2 items-center mt-2 justify-center'>
                <UpdateButton link="/updateLect/" id={item.id}/>
                <DeleteButton link="/deleteLect/" id={item.id} />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default Lectures