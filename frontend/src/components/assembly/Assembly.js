
import "./Assembly.css"
import {useState} from "react";

const Assembly = (props) => {

  const [isHover, setIsHover] = useState(false);

  const handleMouseEnter = () => {
    setIsHover(true);
  };
  const handleMouseLeave = () => {
    setIsHover(false);
  };

  const boxStyle = {
    'height': isHover ? `${350 + 35 * props.ramCombination.length}px` : '20px'
  };

  const isValid = () => {
    return (props.ramCombination.length === props.board.ram_slots &&
      props.ramCombination.map(slot => slot.capacity).reduce((i, a) => i + a, 0) === props.cpu.max_ram_capacity &&
      props.cpu.ram_type === props.board.ram_type
    )
  }

  return (
    <>
      <div
        className={`model model-assembly ${isValid() ? 'model-assembly__valid' : ''}`}
        style={boxStyle}
        onMouseEnter={handleMouseEnter}
        onMouseLeave={handleMouseLeave}
        onClick={() => {props.onClick({fields: props.data})}}
        data-id={props.id}
      >
        <p className={"title"}>{props.name}</p>
        <div className={"components"}>
          <div className={"component component-cpu"}>
            <p className={"title"}>Процессор</p>
            <div className={"component-properties"}>
              <p className={"name"}>Название: {props.cpu.name}</p>
              <p className={"speed"}>Частота: {props.cpu.speed}</p>
              <p className={"architecture"}>Архитектура: {props.cpu.architecture}</p>
              <p className={"ram_type"}>Тип памяти: {props.cpu.ram_type}</p>
              <p className={"max_ram_capacity"}>Макс. объём памяти: {props.cpu.max_ram_capacity}</p>
            </div>
          </div>
          <div className={"component component-board"}>
            <p className={"title"}>Материнская плата</p>
            <div className={"component-properties"}>
              <p className={"name"}>Название: {props.board.name}</p>
              <p className={"architecture"}>Архитектура: {props.board.architecture}</p>
              <p className={"ram_type"}>Тип памяти: {props.board.ram_type}</p>
              <p className={"ram_slots"}>Кол-во слотов памяти: {props.board.ram_slots}</p>
            </div>
          </div>
          <div className={"component component-ram-combination"}>
            <p className={"title"}>Комбинация RAM</p>
            <div className={"component-properties ram-combination"}>
              {props.ramCombination.map(ram => (
                <div className={"ram"}>
                  <p className={"capacity"}>{ram.capacity}</p> -
                  <p className={"name"}>{ram.name}</p>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default Assembly;
