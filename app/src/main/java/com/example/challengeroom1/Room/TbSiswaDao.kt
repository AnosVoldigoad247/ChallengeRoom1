package com.example.challengeroom1.Room

import androidx.room.*

@Dao
interface TbSiswaDao {
    @Insert
    fun addSiswa(siswa: TbSiswa)

    @Update
    fun updateSiswa(siswa: TbSiswa)

    @Delete
    fun deleteSiswa(siswa: TbSiswa)

    @Query("SELECT * FROM TbSiswa")
    fun tampil() : List<TbSiswa>
}