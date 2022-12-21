package CallData.Order
import Factory.IHandler
import com.google.gson.Gson
import groovy.json.JsonSlurper

class OrderHandler implements IHandler{

    private static OrderCalls calls = new OrderCalls();

    @Override
    def String[] getAll() {
        def json = new JsonSlurper().parseText(calls.Get());
        return json."ordernumber"
    }

    @Override
    def String getByID(def ID) {
        def json = new JsonSlurper().parseText(calls.GetByID(ID))

        return  "Date: "     + json."orderdate" + "\n" +
                "UserID: "   + json."userId"    + "\n" +
                "ArticleID " + json."article"
    }

    @Override
    def String postData(Object order){
        def jsonValue = new Gson().toJson(order)
        return calls.Post(jsonValue)
    }

    @Override
    def String updateData(Object order){
        def jsonValue = new Gson().toJson(order)
        return calls.Update(jsonValue)
    }

    @Override
    def String deleteData(def ID){
        return calls.Delete(ID)
    }
}
