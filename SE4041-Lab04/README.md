# SE4041 – Lab Sheet (RecyclerView): Todo app (Android, Kotlin)

> The PDF is named *MADD_Lab_04* but its header says "Lab Sheet 05"; this folder follows the file name.

A Todo application: **enter** a todo, **view all** todos in a **RecyclerView**, and **delete** and **update** them.
Todos are stored in a **Room** database, so they are still there after the app is closed.

## Open and run
Android Studio ▸ **File ▸ Open** ▸ select this folder ▸ Gradle sync ▸ ▶ Run.
(minSdk 26, compileSdk 35, Kotlin 2.0.21, Room 2.6.1 via kapt, package `com.example.madlab04`.)

## Screens (follows the wireframe, bottom buttons **Add Todo** / **View Todos**)
- **Add Todo** – "Enter Todo Item" + **Add**.
- **View Todos** – RecyclerView; each row has a done checkbox (strike-through), **Edit** and **Delete**.
- **Edit** opens the add screen pre-filled ("Edit Todo" / **Save**) and returns to the list afterwards.

## Structure (`app/src/main/java/com/example/madlab04/`)
| File | Role |
|---|---|
| `data/Todo.kt`, `TodoDao.kt`, `TodoDatabase.kt` | Room entity, DAO (insert/update/delete/getAll), database |
| `TodoViewModel.kt` | Shared state: todo list, item being edited, database operations |
| `MainActivity.kt` | Fragment container + bottom navigation buttons |
| `AddTodoFragment.kt` | Add / edit form with validation |
| `TodoListFragment.kt`, `TodoAdapter.kt` | RecyclerView list with checkbox, Edit, Delete |
