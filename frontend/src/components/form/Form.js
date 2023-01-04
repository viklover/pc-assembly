
import "./Form.css"
import FormBackground from "./FormBackground";

const Form = (props) => {

  const submitDisable = props.submitDisabled !== undefined ? props.submitDisabled : false;

  return (
    <>
      <form className={"form " + ((props.active !== undefined && props.active) ? "form-active" : "")}
            action="#"
            onSubmit={props.submitCallback}>
        <header>
          <h3 className={"form__header"}>{props.title}</h3>
        </header>
        <main>
          {props.description !== undefined && (
              <div className={"form__field"}>
                <h4 className={"form__field-name"}>{props.description}</h4>
              </div>
            )}
          {props.children}
        </main>
        <footer>
          <button type="submit"
                  name="submit-button"
                  className={"button form__button " + (submitDisable ? "disabled" : "")}
                  disabled={submitDisable}>
            {props.submit}
          </button>
        </footer>
      </form>
      <FormBackground active={props.active} callback={props.cancelCallback}></FormBackground>
    </>
  )
}

export default Form;
