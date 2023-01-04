import React, { useEffect, useState } from "react";

import Model from "../Model.js";

import CreateModelForm from "../create-model/CreateModelForm.js";
import EditModelForm from "../edit-model/EditModelForm.js";

import "./ModelList.css";

const ModelList = (props) => {
  const service = props.service

  const [models, setModelsList] = useState([])
  const [selectedModel, setSelectedModel] = useState({fields: null})

  const [creationFormState, setCreationFormState] = useState(false)
  const [editFormState, setEditFormState] = useState(false)

  const updateModelsList = async() => {
    setModelsList([])
    setModelsList((await service.findAll()).map(model => {
      return <Model
        pk={props.pk}
        data={model}
        name={props.modelName}
        utils={props.utils}
        onClick={(model) => {
          setSelectedModel(model)
          setEditFormState(true)
        }}/>
    }))
  }

  useEffect(() => {
    updateModelsList()
  }, [])

  return (
    <>
      <div className={"button button-14"} onClick={() => setCreationFormState(true)}>
        Создать {props.modelName}
      </div>

      <div className={"model-list"}>
        {models.map(model => (model))}
      </div>

      <CreateModelForm
        modelName={props.modelName}
        service={props.service}
        utils={props.utils}
        active={creationFormState}
        onSubmit={updateModelsList}
        cancelCallback={() => setCreationFormState(false)}
      />

      <EditModelForm
        modelName={props.modelName}
        service={props.service}
        utils={props.utils}
        active={editFormState}
        onSubmit={updateModelsList}
        cancelCallback={() => setEditFormState(false)}
        selectedModel={selectedModel}
      />
    </>
  )
}

export default ModelList;