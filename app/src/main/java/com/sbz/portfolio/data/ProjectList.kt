package com.sbz.portfolio.data

class ProjectList {

    private val listOfProjects = listOf(
        Projects("Music Player", "A Simple Music Player For android"),
        Projects("Zomato Clone", "Zomato Clone Application"),
        Projects("Movies-Head", "An android application to display all the movie information's"),
        Projects("Get my Notes", "An android application to get Notes of any Subject"),
        Projects("Newsly", "A Simple News Application For android"),
        Projects("Notify", "A Simple Note taking application For android")
    )


    fun getProjectsList(): List<Projects> {
        return listOfProjects
    }

}