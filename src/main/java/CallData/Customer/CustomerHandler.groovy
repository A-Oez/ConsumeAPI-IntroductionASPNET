package CallData.Customer

import Factory.IHandler
import com.google.gson.Gson
import groovy.json.JsonSlurper

class CustomerHandler implements IHandler {

    private static CustomerCalls calls = new CustomerCalls();

    @Override
    def String[] getAll() {
        def json = new JsonSlurper().parseText(calls.Get());
        return json."userId"
    }

    @Override
    def String getByID(def ID) {
        def json = new JsonSlurper().parseText(calls.GetByID(ID))

        return       "forename: "  + json."forename"    + "\n" +
                     "surename: "  + json."surename"    + "\n" +
                     "birthday: "  + json."birthday"    + "\n" +
                     "city: "      + json."city"        + "\n" +
                     "code: "      + json."code"        + "\n" +
                     "street: "    + json."street"      + "\n" +
                     "house: "     + json."houseNumber" + "\n" +
                     "email: "     + json."email"       + "\n" +
                     "telephone: " + json."telephone"
    }

    @Override
    def String postData(Object customer){
        def jsonValue = new Gson().toJson(customer)
        return calls.Post(jsonValue)
    }

    @Override
    def String updateData(Object customer){
        def jsonValue = new Gson().toJson(customer)
        return calls.Update(jsonValue)
    }

    @Override
    def String deleteData(def ID){
        return calls.Delete(ID)
    }
}
