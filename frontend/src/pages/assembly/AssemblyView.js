import Header from "../../components/header/Header.js";
import React from "react";
import AssemblyList from "../../components/assembly/list/AssemblyList";

const AssembliesView = () => {

  return (
    <>
      <Header active={"assemblies"}/>
      <main className={"content"}>
        <AssemblyList />
      </main>
    </>
  );
}

export default AssembliesView;
