import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "./App.css"
import UpdateButton from './components/UpdateButton';
import DeleteButton from './components/DeleteButton';
import { Link } from 'react-router-dom';

const App = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080'); 
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
        <h1 className='self-start w-5/6 text-2xl'>Professors</h1>
        <div className='w-1/6 flex justify-end'>
          <Link to="/lectures">
            <button>Lectures</button>
          </Link>
        </div>
      </div>
      <Link to="addProf">
        <button className='w-full  p-2 border-b-0 
        border-2 bg-blue-600'>
          ADD
        </button>
      </Link>
      <table className="w-full table-fixed">
        <thead>
          <tr className='border-2'>
            <th className='p-3'>Id</th>
            <th>Name</th>
            <th>Department</th>
            <th>More</th>
          </tr>
        </thead>
        <tbody>
          {data.map(item => (
            <tr key={item.id} className="text-center border-2">
              <td className='p-3'>{item.id}</td>
              <td>{item.name}</td>
              <td>{item.department}</td>
              <td className='flex gap-2 items-center mt-2 justify-center'>
                <UpdateButton link="/updateProf/" id={item.id}/>
                <DeleteButton link="/deleteProf/" id={item.id} />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default App;
