
import Header from "../../components/header/Header.js";
import ModelList from "../../components/model/list/ModelList.js";

import RamService from "../../api/services/ram/RamService";
import RamUtils from "../../api/services/ram/RamUtils";

const RamView = () => {

  return (
    <>
      <Header active={"ram"}/>
      <main className={"content"}>
        <ModelList
          modelName={"ram"}
          service={RamService}
          utils={RamUtils}
          pk={"name"}
        />
      </main>
    </>
  );
}

export default RamView;
