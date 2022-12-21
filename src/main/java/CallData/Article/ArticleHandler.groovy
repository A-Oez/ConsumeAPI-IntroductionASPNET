package CallData.Article

import CallData.Article.ArticleCalls
import Factory.IHandler
import com.google.gson.Gson
import groovy.json.JsonSlurper

class ArticleHandler implements IHandler {

    private static ArticleCalls calls = new ArticleCalls();

    @Override
    def String[] getAll(){
        def json = new JsonSlurper().parseText(calls.Get());
        return json."articlenumber"
    }

    @Override
    def String getByID(def ID){
        def json = new JsonSlurper().parseText(calls.GetByID(ID))

        return  "Price: "       + json."price"       + "\n"+
                "Description: " + json."description"
    }

    @Override
    def String postData(Object article){
        def jsonValue = new Gson().toJson(article)
        return calls.Post(jsonValue)
    }

    @Override
    def String updateData(Object article){
        def jsonValue = new Gson().toJson(article)
        return calls.Update(jsonValue)
    }

    @Override
    def String deleteData(def ID){
        return calls.Delete(ID)
    }

}