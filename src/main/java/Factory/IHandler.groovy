package Factory

interface IHandler {

    def String[] getAll();
    def String getByID(def ID);
    def String postData(Object data)
    def String updateData(Object data)
    def String deleteData(def ID)

}