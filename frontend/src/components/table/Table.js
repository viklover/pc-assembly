import React from "react";

const Table = (props) => {

  return (
    <>
      <table className="table current-table">
        <thead>
          <tr className="columns">
            {props.columns.map(column => (
                <th scope={"col"}>{column}</th>
              ))}
          </tr>
        </thead>
        <tbody className="rows">
          {props.rows.map(row => (
              <tr>
                {
                  row.map(value => (
                    <td>{value}</td>
                  ))
                }
              </tr>
            ))}
        </tbody>
      </table>
    </>
  );
}

export default Table;
