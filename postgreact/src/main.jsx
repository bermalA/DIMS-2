import * as React from "react";
import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import "./index.css";
import App from "./App";
import DeleteProf from "./components/DeleteProf";
import UpdateProf from "./components/UpdateProf";
import AddProf from "./components/AddProf";
import Lectures from "./components/Lectures";
import UpdateLect from "./components/UpdateLect";
import AddLect from "./components/AddLect";
import DeleteLect from "./components/DeleteLect";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
  },
  {
    path:"/deleteProf/:id",
    element: <DeleteProf />
  },
  { 
    path:"updateProf/:id",
    element: <UpdateProf />
  },
  {
    path: "/addProf",
    element: <AddProf />
  },
  {
    path: "/lectures",
    element:<Lectures />
  },
  {
    path:"/updateLect/:id",
    element: <UpdateLect/>
  },
  {
    path:"/addLecture",
    element: <AddLect />
  },
  {
    path: "/deleteLect/:id",
    element: <DeleteLect />
  }
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);