
import AssemblyForm from "../form/AssemblyForm";

import AssemblyService from "../../../api/services/assembly/AssemblyService";

const CreateAssemblyForm = (props) => {

  return (
    <>
      <AssemblyForm
        active={props.active}
        title={"Собрать ПК"}
        submitLabel={"Создать"}
        assemblyName={"My Assembly"}
        cancelCallback={props.cancelCallback}
        editState={false}
        selectedAssembly={{}}
        onSubmit={(e, id, assemblyName, cpu, board, ram) => {
          e.preventDefault();

          AssemblyService.create({
            name: assemblyName,
            cpu_id: cpu.id,
            board_id: board.id,
            ram: ram.map(slot => slot.id)
          }).then(res => {
            props.cancelCallback();
            props.onSubmit();
          })
        }}
      />
    </>
  )
}

export default CreateAssemblyForm;
