
import AssemblyForm from "../form/AssemblyForm";
import AssemblyService from "../../../api/services/assembly/AssemblyService";

const EditAssemblyForm = (props) => {

  return (
    <>
      <AssemblyForm
        active={props.active}
        title={"Обновить сборку ПК"}
        submitLabel={"Обновить"}
        selectedAssembly={props.selectedModel}
        cancelCallback={props.cancelCallback}
        editState={true}
        onSubmit={(e, id, assemblyName, cpu, board, ram) => {
          e.preventDefault();

          AssemblyService.update({
            id: id,
            name: assemblyName,
            cpu_id: cpu.id,
            board_id: board.id,
            ram: ram.map(slot => slot.id)
          }).then(res => {
            props.cancelCallback();
            props.onSubmit();
          })
        }}
        onDelete={(e, id) => {
          e.preventDefault();

          AssemblyService.delete(id).then(res => {
            props.cancelCallback();
            props.onSubmit();
          })
        }}
      />
    </>
  )
}

export default EditAssemblyForm;
