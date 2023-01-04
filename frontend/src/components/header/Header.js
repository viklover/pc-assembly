import { Link } from "react-router-dom";

import "./Header.css"

const Header = (props) => {

  return (
    <>
      <header className="head">
        <div className="content container">
          <Link to="/cpu" className={"menu-item" + (props.active === "processors" ? " active" : "")}>Процессоры</Link>
          <Link to="/ram" className={"menu-item" + (props.active === "ram" ? " active" : "")}>Оперативная память</Link>
          <Link to="/boards" className={"menu-item" + (props.active === "boards" ? " active" : "")}>Материснкие платы</Link>
          <Link to="/assemblies" className={"menu-item" + (props.active === "assemblies" ? " active" : "")}>Сборки</Link>
        </div>
      </header>
    </>
  )
}

export default Header;