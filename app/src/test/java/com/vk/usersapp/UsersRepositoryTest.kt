package com.vk.usersapp

import com.vk.usersapp.feature.feed.api.UsersRepository
import com.vk.usersapp.feature.feed.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UsersRepositoryTest {

    private lateinit var usersRepository: UsersRepository
    private val usersList = listOf(
        User(
            firstName = "Terry",
            lastName = "Medhurst",
            image = "https://robohash.org/Terry.png?set=set4",
            university = "Capitol University"
        ),
        User(
            firstName = "Sheldon",
            lastName = "Quigley",
            image = "https://robohash.org/Sheldon.png?set=set4",
            university = "Stavropol State Technical University"
        ),
        User(
            firstName = "Terrill",
            lastName = "Hills",
            image = "https://robohash.org/Terrill.png?set=set4",
            university = "University of Cagayan Valley"
        ),
        User(
            firstName = "Miles",
            lastName = "Cummerata",
            image = "https://robohash.org/Miles.png?set=set4",
            university = "Shenyang Pharmaceutical University"
        ),
        User(
            firstName = "Mavis",
            lastName = "Schultz",
            image = "https://robohash.org/Mavis.png?set=set4",
            university = "Estonian University of Life Sciences"
        ),
        User(
            firstName = "Alison",
            lastName = "Reichert",
            image = "https://robohash.org/Alison.png?set=set4",
            university = "Universidade da Beira Interior"
        ),
        User(
            firstName = "Oleta",
            lastName = "Abbott",
            image = "https://robohash.org/Oleta.png?set=set4",
            university = "Institut Sains dan Teknologi Al Kamal"
        ),
        User(
            firstName = "Ewell",
            lastName = "Mueller",
            image = "https://robohash.org/Ewell.png?set=set4",
            university = "Wenzhou Medical College"
        ),
        User(
            firstName = "Demetrius",
            lastName = "Corkery",
            image = "https://robohash.org/Demetrius.png?set=set4",
            university = "Nanjing University of Economics"
        ),
        User(
            firstName = "Eleanora",
            lastName = "Price",
            image = "https://robohash.org/Eleanora.png?set=set4",
            university = "Melaka City Polytechnic"
        ),
        User(
            firstName = "Marcel",
            lastName = "Jones",
            image = "https://robohash.org/Marcel.png?set=set4",
            university = "Hodeidah University"
        ),
        User(
            firstName = "Assunta",
            lastName = "Rath",
            image = "https://robohash.org/Assunta.png?set=set4",
            university = "Kiev Slavonic University"
        ),
        User(
            firstName = "Trace",
            lastName = "Douglas",
            image = "https://robohash.org/Trace.png?set=set4",
            university = "Dallas Christian College"
        ),
        User(
            firstName = "Enoch",
            lastName = "Lynch",
            image = "https://robohash.org/Enoch.png?set=set4",
            university = "University of Sri Jayawardenapura"
        ),
        User(
            firstName = "Jeanne",
            lastName = "Halvorson",
            image = "https://robohash.org/Jeanne.png?set=set4",
            university = "Donghua University, Shanghai"
        ),
        User(
            firstName = "Trycia",
            lastName = "Fadel",
            image = "https://robohash.org/Trycia.png?set=set4",
            university = "Technical University of Mining and Metallurgy Ostrava"
        ),
        User(
            firstName = "Bradford",
            lastName = "Prohaska",
            image = "https://robohash.org/Bradford.png?set=set4",
            university = "Technical University of Mining and Metallurgy Ostrava"
        ),
        User(
            firstName = "Arely",
            lastName = "Skiles",
            image = "https://robohash.org/Arely.png?set=set4",
            university = "Universidade Estadual do Ceará"
        ),
        User(
            firstName = "Gust",
            lastName = "Purdy",
            image = "https://robohash.org/Gust.png?set=set4",
            university = "Xinjiang University"
        ),
        User(
            firstName = "Lenna",
            lastName = "Renner",
            image = "https://robohash.org/Lenna.png?set=set4",
            university = "Moraine Valley Community College"
        ),
        User(
            firstName = "Doyle",
            lastName = "Ernser",
            image = "https://robohash.org/Doyle.png?set=set4",
            university = "Nanjing University of Traditional Chinese Medicine"
        ),
        User(
            firstName = "Tressa",
            lastName = "Weber",
            image = "https://robohash.org/Tressa.png?set=set4",
            university = "Universitat Rámon Llull"
        ),
        User(
            firstName = "Felicity",
            lastName = "O'Reilly",
            image = "https://robohash.org/Felicity.png?set=set4",
            university = "University of lloilo"
        ),
        User(
            firstName = "Jocelyn",
            lastName = "Schuster",
            image = "https://robohash.org/Jocelyn.png?set=set4",
            university = "Bashkir State Medical University"
        ),
        User(
            firstName = "Edwina",
            lastName = "Ernser",
            image = "https://robohash.org/Edwina.png?set=set4",
            university = "Wuhan University of Technology"
        ),
        User(
            firstName = "Griffin",
            lastName = "Braun",
            image = "https://robohash.org/Griffin.png?set=set4",
            university = "Universitas Bojonegoro"
        ),
        User(
            firstName = "Piper",
            lastName = "Schowalter",
            image = "https://robohash.org/Piper.png?set=set4",
            university = "Sultanah Bahiyah Polytechnic"
        ),
        User(
            firstName = "Kody",
            lastName = "Terry",
            image = "https://robohash.org/Kody.png?set=set4",
            university = "Science University of Tokyo"
        ),
        User(
            firstName = "Macy",
            lastName = "Greenfelder",
            image = "https://robohash.org/Macy.png?set=set4",
            university = "Fuji Women's College"
        ),
        User(
            firstName = "Maurine",
            lastName = "Stracke",
            image = "https://robohash.org/Maurine.png?set=set4",
            university = "Poznan School of Banking"
        )
    )

    private val certainUser = "Terry"
    private val usersCertainList = listOf(
        User(
            firstName = "Terry",
            lastName = "Medhurst",
            image = "https://robohash.org/Terry.png?set=set4",
            university = "Capitol University"
        ),
        User(
            firstName = "Kody",
            lastName = "Terry",
            image = "https://robohash.org/Kody.png?set=set4",
            university = "Science University of Tokyo"
        )
    )


    @Before
    fun setup() {
        usersRepository = UsersRepository()
    }

    @Test
    fun getAllUsersTest() {
        runBlocking {
            val response = usersRepository.getUsers()
            assertEquals(usersList, response)
        }
    }

    @Test
    fun getCertainUsersTest() {
        runBlocking {
            val response = usersRepository.searchUsers(certainUser)
            assertEquals(usersCertainList, response)
        }
    }
}