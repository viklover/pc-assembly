
import { useEffect, useState } from "react";

import Assembly from "../Assembly";

import CreateAssemblyForm from "../create-assembly/CreateAssemblyForm";
import EditAssemblyForm from "../edit-assembly/EditAssemblyForm";

import AssemblyService from "../../../api/services/assembly/AssemblyService";

const AssemblyList = (props) => {

  const [models, setModelsList] = useState([])
  const [selectedModel, setSelectedModel] = useState({fields: null})

  const [creationFormState, setCreationFormState] = useState(false)
  const [editFormState, setEditFormState] = useState(false)

  const updateModelsList = async() => {
    await setModelsList((await AssemblyService.findAll()).map(assembly => {
      return <Assembly
        id={assembly.id}
        name={assembly.name}
        cpu={assembly.cpu}
        board={assembly.board}
        ramCombination={assembly.ram_combination}
        isValid={false}
        data={assembly}
        onClick={(data) => {
          setSelectedModel(data)
          setEditFormState(true)
        }}
      />
    }))
  }

  useEffect(() => {
    updateModelsList()
  }, [])

  return (
    <>
      <div className={"button button-14"} onClick={() => setCreationFormState(true)}>
        Собрать ПК
      </div>

      <div className={"model-list"}>
        {models.map(model => (model))}
      </div>

      <CreateAssemblyForm
        active={creationFormState}
        onSubmit={updateModelsList}
        cancelCallback={() => setCreationFormState(false)}
      />

      <EditAssemblyForm
        active={editFormState}
        onSubmit={updateModelsList}
        cancelCallback={() => setEditFormState(false)}
        selectedModel={selectedModel}
      />
    </>
  )

}

export default AssemblyList;
