# SISOP_Kelompok5_Tugas1
# Kelompok
<table>
    <thead>
        <tr>
            <th>Nama</th>
            <th>NIM</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Naufal Fadhil Arkani</td>
            <td>255150200111037</td>
        </tr>
        <tr>
            <td>Muhammad Reyhan Setya Ardiansyah</td>
            <td>255150207111052</td>
        </tr>
        <tr>
            <td>Bagas Zakaria</td>
            <td>255150207111064</td>
        </tr>
        <tr>
            <td>Ariq Dwi Anugrah</td>
            <td>255150207111053</td>
        </tr>
        <tr>
            <td>Raven Ravellyn Sulistyo</td>
            <td>255150207111061</td>
        </tr>
    </tbody>
</table>



# Tugas Kelompok Sistem Operasi
Membangun Simulator Sederhana Sistem Operasi: CPU Scheduling dan Deadlock Handling.

## Deskripsi Tugas
Program sederhana ini merupakan bentuk simulasi berbasis console/CLI yang memiliki 2 fitur utama:

### Bagian A — Simulasi CPU Scheduling
Program dapat mensimulasikan penjadwalan proses menggunakan algoritma berikut:
* FCFS (First Come First Serve).
* SJF (Shortest Job First) non-preemptive.
* Round Robin.
* Priority Scheduling (Opsional).

Setiap proses minimal menerima input berupa ID Proses, Arrival Time, Burst Time, Priority, dan Quantum. Output yang ditampilkan meliputi:
* Urutan eksekusi proses.
* Gantt Chart sederhana (teks).
* Waiting Time tiap proses.
* Turnaround Time tiap proses.
* Response Time tiap proses.
* Rata-rata Waiting Time.
* Rata-rata Turnaround Time.

### Bagian B — Simulasi Deadlock
Simulasi ini menggunakan salah satu pendekatan berikut:
* Banker’s Algorithm: Program memeriksa apakah sistem berada pada safe state berdasarkan input matriks Allocation, Maximum, dan vektor Available. Output berupa Need Matrix, urutan safe sequence (jika ada), dan status sistem (safe atau unsafe).
* Deteksi Deadlock Sederhana: Program mensimulasikan proses meminta dan melepas resource, mendeteksi deadlock, dan menampilkan proses mana yang terlibat.

## Ketentuan Minimal Program
* Memiliki menu pilihan untuk Scheduling dan Deadlock.
* Menerima input dari pengguna atau file sederhana.
* Menampilkan hasil dengan rapi.
* Terdapat validasi input dasar.
* Source code diberi komentar secukupnya.


## Luaran yang Dikumpulkan
* Source code lengkap yang dapat dijalankan tanpa error.
* Laporan singkat (5–8 halaman).
* Video / Demo singkat (durasi 5–7 menit).
* Presentasi (maksimal 7 slide).

