
const FormBackground = (props) => {
  return (
    <>
      <div
        className={'modal-background ' + (props.active ? 'modal-background-active' : '')}
        onClick={props.callback}
      />
    </>
  );
}

export default FormBackground;
