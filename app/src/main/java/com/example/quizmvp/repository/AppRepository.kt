import com.example.quizmvp.R
import com.example.quizmvp.model.CategoryDate
import com.example.quizmvp.model.QuestionData
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class AppRepository private constructor(){
    private var list = ArrayList<QuestionData>()
    var wrongCount = 0
    var correctCount = 0

    companion object{
       private lateinit var instance: AppRepository

        fun init(){
            if (!(::instance.isInitialized)){
                instance = AppRepository()
            }
        }
        fun getInstance(): AppRepository{
            return instance
        }
    }
    private fun loadTestMath() {
        list.clear()
        list.add(QuestionData("2 * 3 = ?", "6", "2", "3", "7", "6"))
        list.add(QuestionData("Bir uchburchakning ichki burchaklari yig‘indisi nechaga teng?", "180", "90", "270", "360", "180"))
        list.add(QuestionData("25 ning kvadrat ildizi nechaga teng?", "5", "6", "4", "7", "5"))
        list.add(QuestionData("3x + 7 = 16 bo‘lsa, x ning qiymati nechaga teng?", "3", "4", "2", "5", "3"))
        list.add(QuestionData("Bir soat nechta daqiqadan iborat?", "60", "100", "120", "60", "30"))
        list.add(QuestionData("π ning taqribiy qiymati qaysi?", "3.14", "3.14", "1.41", "4.13", "3"))
        list.add(QuestionData("Kvadratning diagonali qanday formula orqali hisoblanadi?", "a√2", "a²", "a√2", "a/2", "2a"))
        list.add(QuestionData("Ikki juft sonning yig‘indisi qanday son bo‘ladi?", "Juft", "Juft", "Toq", "Aniqlab bo‘lmaydi", "Nol"))
        list.add(QuestionData("Ko‘pburchakning ichki burchaklar yig‘indisi qanday formula bilan topiladi?", "(n-2) * 180", "n * 180", "(n-2) * 180", "n * 90", "(n+2) * 180"))
        list.add(QuestionData("Qaysi son natural son emas?", "-1", "0", "-1", "1", "10"))
        list.add(QuestionData("Qaysi geometrik shakl barcha burchaklari teng bo‘lgan?", "Kvadrat", "To‘g‘ri to‘rtburchak", "Kvadrat", "Romb", "Trapetsiya"))
    }

    private fun loadTestPhys() {
        list.clear()
        list.add(QuestionData("Suv qaysi haroratda qaynaydi?", "100°C", "100°C", "80°C", "120°C", "200°C"))
        list.add(QuestionData("Eng tez harakat qiluvchi narsa qaysi?", "Yorug‘lik", "Yorug‘lik", "Elektron", "Samolyot", "Ovoz"))
        list.add(QuestionData("Nyutonning nechta harakat qonuni bor?", "3", "2", "3", "4", "6"))
        list.add(QuestionData("Elektr toki birligi qaysi?", "Amper", "Joul", "Amper", "Volt", "Watt"))
        list.add(QuestionData("Erkin tushish tezlanishi nechiga teng yerda?", "9.8 m/s²", "8.9 m/s²", "10.5 m/s²", "7.5 m/s²", "9.8 m/s²"))
        list.add(QuestionData("Yorug‘lik sekundiga qancha masofani bosib o‘tadi?", "300 000 km", "150 000 km", "300 000 km", "450 000 km", "600 000 km"))
        list.add(QuestionData("Issiqlik uzatishning nechta asosiy turi bor?", "3", "2", "3", "4", "5"))
        list.add(QuestionData("Eng katta elektromagnit to‘lqin nima?", "Radioto‘lqinlar", "Gamma nurlar", "Radioto‘lqinlar", "Mikroto‘lqinlar", "Infraqizil nurlar"))
        list.add(QuestionData("Qaysi modda eng past haroratda suyuqlikka aylanadi?", "Heliy", "Suv", "Heliy", "Azot", "Oksigen"))
        list.add(QuestionData("Qaysi fizik kattalik kuchni bildiradi?", "Nyuton", "Joul", "Nyuton", "Vatt", "Amper"))
    }

    private fun loadTestChem() {
        list.clear()
        list.add(QuestionData("Qaysi birikma suvda eng yaxshi eriydi?", "NaCl (Sodyum xlorid)", "NaCl (Sodyum xlorid)", "CO₂ (Uglerod dioksid)", " O₂ (Kislorod)", "N₂ (Azot)"))
        list.add(QuestionData("Quyidagi moddalar orasida eng kuchli kislotani toping:", "H₂SO₄ (Sulfurik kislotasi)", "H₂SO₄ (Sulfurik kislotasi)", "HNO₃ (Azot kislotasi)", "H₃PO₄ (Fosfor kislotasi)", "HNO₃ (Azot kislotasi)"))
        list.add(QuestionData("Ammiakning (NH₃) kimyoviy xossasi qanday?", "Asos", "Kislotali", "Asos", "Neytral", "Hali aniqlanmagan"))
        list.add(QuestionData("Agar modda qattiq holatdan gaz holatiga o‘tsa, bu qanday jarayon?", "Sublimatsiya", "Qaynatish", "Sublimatsiya", "Kondensatsiya", "Eritish"))
        list.add(QuestionData("Kimyo elementlari jadvalining muallifi kim?", "Dmitriy Mendeleyev", "Antuan Lavoazye", "Dmitriy Mendeleyev", "Marie Kyuri", "Ernest Rezerford"))
        list.add(QuestionData("Havo tarkibida eng ko‘p uchraydigan gaz qaysi?", "Azot", "Kislorod", "Azot", "Argon", "Karbonat angidrid"))
        list.add(QuestionData("Oqsillar qanday molekulalardan tashkil topgan?", "Aminokislotalar", "Uglevodlar", "Aminokislotalar", "Lipidlar", "Vitaminlar"))
        list.add(QuestionData("Eng yengil kimyoviy element qaysi?", "Vodorod", "Geli", "Vodorod", "Kislorod", "Azot"))
        list.add(QuestionData("Qaysi kimyoviy element inson tanasida eng ko‘p uchraydi?", "Kislorod", "Uglerod", "Kislorod", "Azot", "Vodorod"))
        list.add(QuestionData("PH 7 ga teng bo‘lsa, muhit qanday bo‘ladi?", "Neytral", "Kislotali", "Neytral", "Asosiy", "Zaharli"))
    }
    private fun loadTestHistory() {
        list.clear()
        list.add(QuestionData("Ikkinchi jahon urushi qachon boshlangan?", "1939", "1939", "1941", "1914", "1923"))
        list.add(QuestionData("Buyuk ipak yo‘li qaysi davrda rivojlangan?", "O‘rta asrlar", "Yangi asr", "O‘rta asrlar", "Qadimgi dunyo", "Hozirgi zamon"))
        list.add(QuestionData("Amir Temur qaysi yili tug‘ilgan?", "1336", "1336", "1350", "1405", "1320"))
        list.add(QuestionData("Birinchi inson qaysi qit'ada paydo bo‘lgan?", "Afrika", "Afrika", "Yevropa", "Osiyo", "Amerika"))
        list.add(QuestionData("Mustaqil O‘zbekiston Respublikasi qachon tashkil topgan?", "1991", "1989", "1991", "1995", "2000"))
        list.add(QuestionData("Napoleon qaysi davlatni boshqargan?", "Fransiya", "Angliya", "Fransiya", "Germaniya", "Italiya"))
        list.add(QuestionData("Rim imperiyasi qachon quladi?", "476", "1000", "476", "1453", "800"))
        list.add(QuestionData("O'rta asrlarning eng mashhur sarkardalaridan biri kim?", "Chingizxon", "Napoleon", "Chingizxon", "Julius Sezar", "Atilla"))
        list.add(QuestionData("Birinchi jahon urushi qachon boshlangan?", "1914", "1912", "1914", "1918", "1920"))
        list.add(QuestionData("Buyuk Britaniya necha yil davomida Hindistonni mustamlaka qilgan?", "200", "100", "200", "300", "150"))
    }

    private fun loadTestGeography() {
        list.clear()
        list.add(QuestionData("Yerning eng katta okeani qaysi?", "Tinch okeani", "Atlantika okeani", "Hind okeani", "Tinch okeani", "Shimoliy muz okeani"))
        list.add(QuestionData("Eng katta qit'a qaysi?", "Osiyo", "Yevropa", "Afrika", "Osiyo", "Shimoliy Amerika"))
        list.add(QuestionData("Dunyodagi eng uzun daryo qaysi?", "Nil", "Amazonka", "Nil", "Missisipi", "Dunay"))
        list.add(QuestionData("Yer yuzasining necha foizi suv bilan qoplangan?", "71%", "50%", "71%", "80%", "60%"))
        list.add(QuestionData("Qaysi mamlakat ikki qit'ada joylashgan?", "Turkiya", "Rossiya", "Turkiya", "Misr", "Kanada"))
        list.add(QuestionData("O‘zbekiston bilan chegaradosh davlatlardan biri qaysi?", "Qozog‘iston", "Tojikiston", "Qozog‘iston", "Turkmaniston", "Afg‘oniston"))
        list.add(QuestionData("Dunyodagi eng baland tog' tizmasi qaysi?", "Himolay", "And", "Himolay", "Alp", "Kavkaz"))
        list.add(QuestionData("Yer qaysi qatlamdan iborat emas?", "Atmosfera", "Magma", "Atmosfera", "Litosfera", "Yadro"))
        list.add(QuestionData("Qaysi mamlakat eng ko‘p aholi soniga ega?", "Xitoy", "Hindiston", "Xitoy", "AQSh", "Braziliya"))
        list.add(QuestionData("Amazonka o‘rmonlari qaysi qit'ada joylashgan?", "Janubiy Amerika", "Afrika", "Janubiy Amerika", "Osiyo", "Avstraliya"))
    }

    private fun loadTestBiology() {
        list.clear()
        list.add(QuestionData("Qaysi organ inson tanasida qonni filtrlash vazifasini bajaradi?", "Buyrak", "Jigar", "Buyrak", "Yurak", "O‘pka"))
        list.add(QuestionData("DNK nima vazifani bajaradi?", "Genetik ma'lumot saqlaydi", "Qon aylanishi", "Genetik ma'lumot saqlaydi", "Nafas olish", "Hujayralarni oziqlantirish"))
        list.add(QuestionData("Eng katta inson organi qaysi?", "Teri", "Jigar", "Buyrak", "Teri", "Yurak"))
        list.add(QuestionData("Odam tanasida nechta suyak bor?", "206", "100", "150", "206", "250"))
        list.add(QuestionData("Fotosintez jarayoni qaysi organoidda sodir bo‘ladi?", "Xloroplast", "Mitochondriya", "Ribosoma", "Xloroplast", "Yadro"))
        list.add(QuestionData("Qonning qaysi tarkibiy qismi kislorod tashiydi?", "Gemoglobin", "Eritrotsit", "Leykotsit", "Trombosit", "Gemoglobin"))
        list.add(QuestionData("Odam tanasining eng kuchli muskuli qaysi?", "Jag' muskuli", "Yurak", "Biceps", "Jag' muskuli", "Son muskuli"))
        list.add(QuestionData("Eng katta inson xromosoma soni nechta?", "46", "23", "46", "92", "44"))
        list.add(QuestionData("Viruslar qanday ko‘payadi?", "Hujayrada", "O‘zi mustaqil", "Hujayrada", "Tuproqda", "Suvda"))
        list.add(QuestionData("O‘simliklarda suvni so‘rib olish organi qaysi?", "Ildiz", "Poya", "Ildiz", "Barg", "Meva"))
    }

    private fun loadTestInformatics() {
        list.clear()
        list.add(QuestionData("Birinchi elektron kompyuter qaysi yil yaratildi?", "1946", "1936", "1946", "1951", "1965"))
        list.add(QuestionData("Internet qachon paydo bo‘lgan?", "1969", "1950", "1969", "1983", "1995"))
        list.add(QuestionData("Eng birinchi dasturlash tili qaysi?", "Fortran", "Java", "Python", "Fortran", "C++"))
        list.add(QuestionData("Operatsion tizim nima?", "Kompyuter dasturi", "Qurilma", "Kompyuter dasturi", "Internet", "Server"))
        list.add(QuestionData("Eng ko‘p ishlatiladigan dasturlash tili?", "Python", "Java", "Python", "C++", "JavaScript"))
        list.add(QuestionData("Kompyuterning asosiy bloklari nechta?", "3", "2", "4", "3", "5"))
        list.add(QuestionData("Sun’iy intellekt qanday ishlaydi?", "Ma’lumotlarni qayta ishlash", "Elektron pochtalar yaratish", "Ma’lumotlarni qayta ishlash", "Hujjat yozish", "O‘yin o‘ynash"))
        list.add(QuestionData("Qaysi dastur veb-sahifalarni yaratishda ishlatiladi?", "HTML", "C++", "Python", "HTML", "SQL"))
        list.add(QuestionData("Qaysi dastur kod yozish uchun ishlatiladi?", "IDE", "Excel", "PowerPoint", "IDE", "Paint"))
        list.add(QuestionData("Ma’lumotlar bazasini boshqarish tizimi?", "SQL", "HTML", "CSS", "JavaScript", "SQL"))
    }

    private fun loadTestLiterature() {
        list.clear()
        list.add(QuestionData("Shakespeare qaysi asarni yozmagan?", "Uch mushketyor", "Hamlet", "Romeo va Julietta", "Uch mushketyor", "Otello"))
        list.add(QuestionData("Alisher Navoiy qaysi asarni yozgan?", "Xamsa", "Devonu Lug‘at-it Turk", "Boburnoma", "Xamsa", "Shohnoma"))
        list.add(QuestionData("Doston nima?", "She’riy epik janr", "Nasriy janr", "She’riy epik janr", "Dramatik janr", "Satirik janr"))
        list.add(QuestionData("Abdulla Qodiriyning mashhur romani?", "O‘tkan kunlar", "Mehrobdan chayon", "O‘tkan kunlar", "Qutlug‘ qon", "Ikki eshik orasi"))
        list.add(QuestionData("Buyuk rus shoiri kim?", "Pushkin", "Dostoyevskiy", "Pushkin", "Tolstoy", "Gogol"))
        list.add(QuestionData("Jaloliddin Rumiy qaysi she’riy yo‘nalishda yozgan?", "Tasavvufiy", "Satirik", "Tasavvufiy", "Romantik", "Realistik"))
        list.add(QuestionData("Dramaturgiya nima?", "Teatr uchun yozilgan asarlar", "She’riy janr", "Teatr uchun yozilgan asarlar", "Ilmiy asarlar", "Detektiv asarlar"))
        list.add(QuestionData("O‘zbek adabiyotining asoschilaridan biri?", "Alisher Navoiy", "Bobur", "Alisher Navoiy", "Mashrab", "Furqat"))
        list.add(QuestionData("Realizm yo‘nalishi qachon shakllangan?", "XIX asr", "XVIII asr", "XIX asr", "XX asr", "XVI asr"))
        list.add(QuestionData("Epik asar nima?", "Hikoya qiluvchi asar", "Dramatik asar", "Hikoya qiluvchi asar", "Lirik asar", "Satirik asar"))
    }

    private fun loadTestEnglish() {
        list.clear()
        list.add(QuestionData("What is the synonym of 'happy'?", "Joyful", "Sad", "Angry", "Joyful", "Tired"))
        list.add(QuestionData("Which word means the opposite of 'big'?", "Small", "Huge", "Small", "Tall", "Long"))
        list.add(QuestionData("What is the past tense of 'go'?", "Went", "Gone", "Goes", "Went", "Going"))
        list.add(QuestionData("Which of these is a noun?", "Dog", "Run", "Fast", "Dog", "Quickly"))
        list.add(QuestionData("How do you spell the number 50?", "Fifty", "Fivety", "Fifty", "Fivty", "Fiveteen"))
        list.add(QuestionData("What is the capital of England?", "London", "Paris", "New York", "London", "Berlin"))
        list.add(QuestionData("Which sentence is correct?", "She goes to school", "She go to school", "She goes to school", "She going to school", "She went to school"))
        list.add(QuestionData("What is the plural of 'child'?", "Children", "Childs", "Children", "Childes", "Childrens"))
        list.add(QuestionData("How do you say 'salom' in English?", "Hello", "Goodbye", "Hello", "Please", "Thanks"))
        list.add(QuestionData("What is the opposite of 'fast'?", "Slow", "Quick", "Fast", "Speedy", "Slow"))
    }

    private fun loadTestRussian() {
        list.clear()
        list.add(QuestionData("Какой сегодня день недели?", "Понедельник", "Понедельник", "Вторник", "Среда", "Четверг"))
        list.add(QuestionData("Как переводится слово 'книга'?", "Book", "Pen", "Book", "Table", "Chair"))
        list.add(QuestionData("Какой цвет получается при смешивании синего и желтого?", "Зелёный", "Красный", "Зелёный", "Фиолетовый", "Оранжевый"))
        list.add(QuestionData("Сколько букв в русском алфавите?", "33", "30", "33", "26", "35"))
        list.add(QuestionData("Какое время суток между утром и вечером?", "День", "Утро", "День", "Ночь", "Полдень"))
        list.add(QuestionData("Как называется столица России?", "Москва", "Санкт-Петербург", "Москва", "Казань", "Новосибирск"))
        list.add(QuestionData("Кто написал 'Война и мир'?", "Толстой", "Достоевский", "Толстой", "Гоголь", "Пушкин"))
        list.add(QuestionData("Как переводится слово 'солнце' на английский язык?", "Sun", "Moon", "Sun", "Star", "Sky"))
        list.add(QuestionData("Какое слово является антонимом слова 'холодный'?", "Тёплый", "Мягкий", "Тёплый", "Жёсткий", "Лёгкий"))
        list.add(QuestionData("Как называется главный праздник в России?", "Новый год", "Рождество", "Новый год", "Пасха", "День Победы"))
    }

    private fun loadTestIQ() {
        list.clear()
        list.add(QuestionData("Tug‘ilgan kunini har yili atigi bir marta nishonlaydigan inson kim?", "Har bir inson", "Futbolchi", "Har bir inson", "Matematik", "Shifokor"))
        list.add(QuestionData("Qaysi so‘z noto‘g‘ri yozilgan?", "Noto‘g‘ri", "Tog‘ri", "Noto‘g‘ri", "To‘g‘ri", "Tug‘ri"))
        list.add(QuestionData("Qaysi hayvon eng tez yuguradi?", "Gepard", "Sher", "Gepard", "Ot", "Bo‘ri"))
        list.add(QuestionData("Agar bugun chorshanba bo‘lsa, 3 kundan keyin qaysi kun bo‘ladi?", "Shanba", "Juma", "Shanba", "Dushanba", "Yakshanba"))
        list.add(QuestionData("3, 6, 9, 12, ... keyingi son qaysi?", "15", "18", "15", "20", "16"))
        list.add(QuestionData("Qaysi meva daraxtda o‘sadi?", "Olma", "Qovun", "Olma", "Tarvuz", "Sabzi"))
        list.add(QuestionData("Bir hafta nechta kun?", "7", "5", "7", "10", "6"))
        list.add(QuestionData("Eng katta sayyora qaysi?", "Yupiter", "Yer", "Yupiter", "Mars", "Venera"))
        list.add(QuestionData("100 ning 50% nechaga teng?", "50", "25", "50", "75", "10"))
        list.add(QuestionData("Qaysi rang sariq va qizil ranglarni aralashtirganda hosil bo‘ladi?", "To‘q sariq", "Ko‘k", "To‘q sariq", "Yashil", "Pushti"))
    }
     fun categoryList(): List<CategoryDate>{
        val list= listOf(
            CategoryDate(1, R.drawable.math_img,"Matematika"),
            CategoryDate(2, R.drawable.fizika_img,"Fizika"),
            CategoryDate(3, R.drawable.chem_img,"Kimyo"),
            CategoryDate(4, R.drawable.history_img,"Tarix"),
            CategoryDate(5, R.drawable.geograpy_img,"Geografiya"),
            CategoryDate(6, R.drawable.biology_img,"Bialogiya"),
            CategoryDate(7, R.drawable.informatic_img,"Informatika"),
            CategoryDate(8, R.drawable.literatura_img,"Adabiyot"),
            CategoryDate(9, R.drawable.english_img,"Ingliz tili"),
            CategoryDate(10, R.drawable.russian_img,"Rus tili"),
            CategoryDate(11,R.drawable.iq_img,"IQ")
        )
         return list
    }
    fun getTests(count: Int, id: Int): List<QuestionData>{
        when(id){
            1 -> loadTestMath()
            2 -> loadTestPhys()
            3 -> loadTestChem()
            4 -> loadTestHistory()
            5 -> loadTestGeography()
            6 -> loadTestBiology()
            7 -> loadTestInformatics()
            8 -> loadTestLiterature()
            9 -> loadTestEnglish()
            10 -> loadTestRussian()
            11 -> loadTestIQ()
        }
        list.shuffle()
        return if (count > list.size) list else list.take(count)
    }
}