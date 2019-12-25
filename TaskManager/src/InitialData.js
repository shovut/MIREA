const initialStateData = {
  tasks: {
    "task-1": { id: "task-1", content: "Радоваться жизни" },
    "task-2": { id: "task-2", content: "Сдать веб" },
    "task-3": { id: "task-3", content: "Написать веб" },
  },
  columns: {
    "column-1": {
      id: "column-1",
      title: "ToDo",
      // Ensures ownership and order of the task
      taskIds: ["task-1"]
    },
    "column-2": {
      id: "column-2",
      title: "InProgress",
      // Ensures ownership and order of the task
      taskIds: ["task-2"]
    },
    "column-3": {
      id: "column-3",
      title: "Done",
      // Ensures ownership and order of the task
      taskIds: ["task-3"]
    }
  },
  // Allows the reordering of the columns
  columnOrder: ["column-1", "column-2", "column-3"]
};

export default initialStateData;
