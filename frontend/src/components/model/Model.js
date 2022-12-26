
import "./Model.css"

const Model = (props) => {

  return (
    <>
      <div className={`model model-${props.name}`} onClick={() => {props.onClick({fields: props.data})}} data-id={props.data.id}>
        {props.pk !== undefined && <h3>{props.data[props.pk]}</h3>}
        <div className={"properties"}>
          {Object.entries(props.data).map(([key, value]) => (
            key !== props.pk && key !== 'id' && <p>{props.utils.FIELDS[key].label}: {value}</p>
          ))}
        </div>
      </div>
    </>
  )
}

export default Model;
