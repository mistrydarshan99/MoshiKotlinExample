package de.stefanmedack.model

import com.squareup.moshi.JsonAdapter
import de.stefanmedack.MoshiBuilder
import de.stefanmedack.exampledata.ArticleExampleData.fullArticleInstance
import de.stefanmedack.exampledata.ArticleExampleData.fullArticleJson
import de.stefanmedack.exampledata.ArticleExampleData.minimalArticleContentInstance
import de.stefanmedack.exampledata.ArticleExampleData.minimalArticleContentJson
import de.stefanmedack.exampledata.ArticleExampleData.minimalArticleInstance
import de.stefanmedack.exampledata.ArticleExampleData.minimalArticleJson
import org.amshove.kluent.shouldBeNull
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class ArticleJsonTest {

    lateinit var adapter: JsonAdapter<Article>

    @Before
    fun setUp() {
        val moshi = MoshiBuilder.moshiInstance
        adapter = moshi.adapter(Article::class.java)
    }

    @Test
    fun `Parse minimal valid json to Article`() {
        adapter.fromJson(minimalArticleJson) shouldEqual minimalArticleInstance
    }

    @Test
    fun `Parse minimal valid json with ContentModules to Article`() {
        adapter.fromJson(minimalArticleContentJson) shouldEqual minimalArticleContentInstance
    }

    @Test
    fun `Parse full valid json to Article`() {
        adapter.fromJson(fullArticleJson) shouldEqual fullArticleInstance
    }

    @Test
    fun `Parse empty json to Article should not crash but be null`() {
        adapter.fromJson("{}").shouldBeNull()
    }

}