
import Header from "../../components/header/Header.js";
import ModelList from "../../components/model/list/ModelList.js";

import BoardService from "../../api/services/board/BoardService";
import BoardUtils from "../../api/services/board/BoardUtils";

const BoardsView = () => {

  return (
    <>
      <Header active={"boards"}/>
      <main className={"content"}>
        <ModelList
          modelName={"board"}
          service={BoardService}
          utils={BoardUtils}
          pk={"name"}
        />
      </main>
    </>
  );
}

export default BoardsView;
