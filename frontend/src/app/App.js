import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";

import CpuView from "../pages/cpu/CpuView.js";
import RamView from "../pages/ram/RamView.js";
import BoardsView from "../pages/board/BoardView.js";
import AssembliesView from "../pages/assembly/AssemblyView.js";

import "./App.css"

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Navigate to="/cpu" replace />} />
        <Route path="/ram" element={<RamView />} />
        <Route path="/boards" element={<BoardsView />} />
        <Route path="/cpu" element={<CpuView />} />
        <Route path="/assemblies" element={<AssembliesView />} />
      </Routes>
    </>
  );
};

export default App;
