
import Header from "../../components/header/Header.js";
import ModelList from "../../components/model/list/ModelList.js";

import CpuService from "../../api/services/cpu/CpuService.js";
import CpuUtils from "../../api/services/cpu/CpuUtils";

const ProcessorsView = () => {

  return (
    <>
      <Header active={"processors"}/>
      <main className={"content"}>
        <ModelList
          modelName={"processor"}
          service={CpuService}
          utils={CpuUtils}
          pk={"name"}
        />
      </main>
    </>
  );
}

export default ProcessorsView;
