package pe.com.examencl2.ProyectoREST

data class ItBookList(
    val error : String,
    val total: String,
    val page: String,
    val books: List<Book>
) {
}