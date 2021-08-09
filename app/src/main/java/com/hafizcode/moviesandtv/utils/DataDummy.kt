package com.hafizcode.moviesandtv.utils

import com.hafizcode.moviesandtv.R
import com.hafizcode.moviesandtv.data.DataEntity

object DataDummy {

    fun generateDummyMovies(): List<DataEntity> {
        val movies = ArrayList<DataEntity>()

        movies.add(
            DataEntity(
                "1",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "Adventure, Action, Science Fiction",
                "7 April 2018",
                "13+",
                "8.3",
                "2h 29m",
                R.drawable.m_poster_infinity_war.toString()
            )
        )
        movies.add(
            DataEntity(
                "2",
                "Mary Queen Of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "Drama, History",
                "21 December 2018",
                "17+",
                "6.6",
                "2h 4m",
                R.drawable.m_poster_marry_queen.toString()
            )
        )
        movies.add(
            DataEntity(
                "3",
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "Action",
                "26 December 2018",
                "13+",
                "6.0",
                "1h 47m",
                R.drawable.m_poster_master_z.toString()
            )
        )
        movies.add(
            DataEntity(
                "4",
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "Adventures, Science Fiction",
                "14 December 2018",
                "13+",
                "6.1",
                "2h 9m",
                R.drawable.m_poster_mortal_engines.toString()
            )
        )
        movies.add(
            DataEntity(
                "5",
                "Overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "Horror, War, Science Fiction",
                "9 November 2018",
                "17+",
                "6.7",
                "1h 5m",
                R.drawable.m_poster_overlord.toString()
            )
        )
        movies.add(
            DataEntity(
                "6",
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "Family, Animation, Comedy, Adventure",
                "21 November 2018",
                "-",
                "7.2",
                "1h 52m",
                R.drawable.m_poster_ralph.toString()
            )
        )
        movies.add(
            DataEntity(
                "7",
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "Adventure, Action, Thriller",
                "21 November 2018",
                "13+",
                "5.9",
                "1h 56m",
                R.drawable.m_poster_robin_hood.toString()
            )
        )
        movies.add(
            DataEntity(
                "8",
                "Serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "Thriller, Mystery, Drama",
                "25 January 2019",
                "17+",
                "5.4",
                "1h 42m",
                R.drawable.m_poster_serenity.toString()
            )
        )
        movies.add(
            DataEntity(
                "9",
                "Spider-Man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "14 December 2018",
                "-",
                "8.4",
                "1h 57m",
                R.drawable.m_poster_spiderman.toString()
            )
        )
        movies.add(
            DataEntity(
                "10",
                "T-34",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "War, Action, Drama, History",
                "1 January 2019",
                "12+",
                "6.9",
                "2h 19m",
                R.drawable.m_poster_t34.toString()
            )
        )

        return movies
    }

    fun generateDummyTV(): List<DataEntity> {
        val tv = ArrayList<DataEntity>()

        tv.add(
            DataEntity(
                "1",
                "Marvel's Iron Fist",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "2017",
                "-",
                "6.6",
                "55m",
                R.drawable.tv_poster_iron_fist.toString()
            )
        )
        tv.add(
            DataEntity(
                "2",
                "Naruto Shippūden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "2017",
                "14+",
                "8.6",
                "25m",
                R.drawable.tv_poster_naruto_shipudden.toString()
            )
        )
        tv.add(
            DataEntity(
                "3",
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "Crime, Action & Adventure, Drama",
                "2003",
                "14+",
                "7.4",
                "45m",
                R.drawable.tv_poster_ncis.toString()
            )
        )
        tv.add(
            DataEntity(
                "4",
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Mystery, Drama, Crime",
                "2017",
                "14+",
                "8.6",
                "45m",
                R.drawable.tv_poster_riverdale.toString()
            )
        )
        tv.add(
            DataEntity(
                "5",
                "Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "Drama, Comedy",
                "2011",
                "17+",
                "8.0",
                "57m",
                R.drawable.tv_poster_shameless.toString()
            )
        )
        tv.add(
            DataEntity(
                "6",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "2015",
                "14+",
                "7.3",
                "42m",
                R.drawable.tv_poster_supergirl.toString()
            )
        )
        tv.add(
            DataEntity(
                "7",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "2015",
                "14+",
                "8.2",
                "52m",
                R.drawable.tv_poster_supernatural.toString()
            )
        )
        tv.add(
            DataEntity(
                "8",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "Family, Animation, Comedy",
                "1989",
                "-",
                "7.8",
                "22m",
                R.drawable.tv_poster_the_simpson.toString()
            )
        )
        tv.add(
            DataEntity(
                "9",
                "The Umbrella Academy",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "Action & Adventure, Sci-Fi & Fantasy, Drama",
                "2019",
                "17+",
                "8.7",
                "55m",
                R.drawable.tv_poster_the_umbrella.toString()
            )
        )
        tv.add(
            DataEntity(
                "10",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "2010",
                "17+",
                "8.1",
                "42m",
                R.drawable.tv_poster_the_walking_dead.toString()
            )
        )

        return tv
    }
}