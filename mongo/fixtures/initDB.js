db = db.getSiblingDB("depa");
db.questions.drop();

db.questions.save({
  choices: [
    { label: "Berlin", isCorrectAnswer: false },
    { label: "Leipzig", isCorrectAnswer: false },
    { label: "Munich", isCorrectAnswer: true },
    { label: "Zurich", isCorrectAnswer: false },
  ],
  name: "If you want to avoid COVID-19, what place that you must not go?",
  type: "OBJECTIVE",
  categories: [
    { label: "computer", backgroundColor: "#2d2a4a", color: "#ffffff" },
    { label: "history", backgroundColor: "#000000", color: "#aaa" },
  ],
  _class: "com.depa.exam.model.question.ObjectiveQuestion",
});
