import { useEffect, useState } from "react";

import Form from "../../form/Form";

import CpuService from "../../../api/services/cpu/CpuService";
import BoardService from "../../../api/services/board/BoardService";
import RamService from "../../../api/services/ram/RamService";

const AssemblyForm = (props) => {

  const [assemblyName, setName] = useState("My Assembly")

  const [id, setId] = useState(null)
  const [cpu, setCpu] = useState(null)
  const [cpuList, setCpuList] = useState([])

  const [board, setBoard] = useState(null)
  const [boardList, setBoardList] = useState([])

  const [ram, setRam] = useState([])
  const [selectedRam, setSelectedRam] = useState(null)
  const [ramList, setRamList] = useState([])

  const [errorMessage, setErrorMessage] = useState("")

  const [isLoading, setLoadingState] = useState(false)

  const findModelByIdInList = (id, list) => {
    for (let model of list) {
      if (model.id == id)
        return model
    }
    return null;
  }

  const addRam = () => {
    let ramArray = []
    ram.forEach(slot => ramArray.push(slot))
    ramArray.push(findModelByIdInList(selectedRam.id, ramList))
    setRam(ramArray)
  }

  const removeRam = (index) => {
    let ramArray = []
    ram.forEach(slot => ramArray.push(slot))
    ramArray.splice(index, 1)
    setRam(ramArray)
  }

  useEffect((e) => {

    setLoadingState(true)

    if (!props.editState || props.selectedAssembly === undefined || props.selectedAssembly.fields == null)
      return;

    let properties = props.selectedAssembly.fields

    setId(properties.id)
    setName(properties.name)
    setCpu(properties.cpu)
    setBoard(properties.board)
    setRam(properties.ram_combination)

  }, [props])

  useEffect(() => {
    (async() => {
      let cpuArray = await CpuService.findAll();
      setCpuList(cpuArray)
      if (cpuArray.length > 0) setCpu(cpuArray[0])
    })()
  }, [])

  useEffect(() => {
    (async() => {
      if (cpu == null) return
      let boardArray = await BoardService.findByCpuArchitectureAndRamType(cpu.architecture, cpu.ram_type)
      setBoardList(boardArray)
      if (boardArray.length > 0 && (!props.editState | !isLoading))
        setBoard(boardArray[0])
      setLoadingState(false)
    })()
  }, [cpu])

  useEffect(() => {
    (async() => {
      if (board == null) return;
      let ramArray = await RamService.findByRamType(cpu.ram_type);
      setRamList(ramArray)
      if (!props.editState | !isLoading) setRam([])
      if (ramArray.length > 0) setSelectedRam(ramArray[0])
    })()
  }, [board])

  const countAmountRamCapacity = () => {
    return ram.map(slot => slot.capacity).reduce((i, a) => i + a, 0);
  }

  const isValid = () => {

    if (cpu == null || board == null)
      return false;

    return (ram.length === board.ram_slots &&
      countAmountRamCapacity() === cpu.max_ram_capacity &&
      cpu.ram_type === board.ram_type
    )
  }

  return (
    <>
      <Form
        title={props.title}
        active={props.active}
        submitDisabled={!isValid()}
        submit={props.submitLabel}
        submitCallback={(e) => {
          props.onSubmit(e, id, assemblyName, cpu, board, ram)
        }}
        cancelCallback={props.cancelCallback}
      >
        <div className="form__field">
          <label htmlFor="name" className="form__field-name">Название</label>
          <input name="name"
                 type="text"
                 value={assemblyName}
                 onInput={(e) => setName(e.target.value)}/>
        </div>

        <div className="form__field">
          <label htmlFor="cpu" className="form__field-name">Процессор</label>
          <select
            name="cpu"
            value={cpu != null ? cpu.id : undefined}
            onChange={async(e) => {
              setCpu(findModelByIdInList(e.target.value, cpuList))
            }}
          >
            {cpuList.map(cpu => (
              <option value={cpu.id}>{cpu.name} - {cpu.architecture}, {cpu.ram_type}</option>
            ))}
          </select>
        </div>

        <div className="form__field">
          <label htmlFor="board" className="form__field-name">Материнская плата</label>
          <select
            name="board"
            value={board != null ? board.id : undefined}
            onChange={async(e) => {
              setBoard(findModelByIdInList(e.target.value, boardList))
            }}>
            {boardList.map(board => (
              <option value={board.id}>{board.name} - {board.cpu_architecture}, {board.ram_type}</option>
            ))}
          </select>
        </div>

        <div className="form__field">
          <label htmlFor="ram" className="form__field-name">Оперативная память</label>
          <div className={"ram_editor"}>
            <div className={"ram_editor-header"}>
              <button
                className={"add_button"}
                onClick={(e) => {e.preventDefault(); addRam()}}
                disabled={board != null && ram.length >= board.ram_slots && true}>+</button>
              <select
                name={"ram"}
                onChange={(e) => setSelectedRam(findModelByIdInList(e.target.value, ramList))}
              >
                {ramList.map(ram => (
                  <option value={ram.id}>{ram.name}: {ram.capacity} - {ram.type}</option>
                ))}
              </select>
            </div>
            <hr />
            <div className={"ram_list"}>
              {Object.entries(ram).map(([index, slot]) => (
                <div className={"ram_list-item"}>
                  <button className={"remove_button"} data-index={index} onClick={(e) => {
                    e.preventDefault();
                    removeRam(parseInt(e.target.dataset.index))
                  }}>-</button>
                  <div className={"ram_list-item"} data-capacity={slot.capacity}>{slot.name}: {slot.capacity}</div>
                </div>
              ))}
            </div>
            <hr />
            {board != null && cpu != null && (
              <p className={`${isValid() ? "black": "red"}`}>{ram.length} из {board.ram_slots} / {countAmountRamCapacity()} из {cpu.max_ram_capacity}</p>
            )}
          </div>
        </div>
        <p>{errorMessage}</p>
        {props.editState && (
          <button type="submit"
                  name="submit-button"
                  onClick={(e) => props.onDelete(e, id)}
                  className={"button form__button-delete "}>
            Удалить
          </button>
        )}
      </Form>
    </>
  )
}

export default AssemblyForm;
