import logo from './logo.svg';
import './App.css';

function App() {
  const name = "Presidency University";
  const students = [
    { name: "John Doe", RollNo: "101", course: "Computer Science", Age: 20, Email: "priyasaroy@gmail.com" },
    { name: "Jane Smith", RollNo: "102", course: "Mathematics", Age: 22, Email: "tapu@gamil.com" },
    { name: "Alice Johnson", RollNo: "103", course: "Physics", Age: 21, Email: "papan@gmail.com" }
  ]
  return (
    <div className="app">
      <h1>Hello, {name}!</h1>
      <h2>Student Details</h2>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>RollNo</th>
            <th>Course</th>
            <th>Age</th>
            <th>Email</th>

          </tr>
        </thead>
        <tbody>
          {students.map((std, index) => (
            <tr key={index}>
              <td>{std.name}</td>
              <td>{std.RollNo}</td>
              <td>{std.course}</td>
              <td>{std.Age}</td>
              <td>{std.Email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
