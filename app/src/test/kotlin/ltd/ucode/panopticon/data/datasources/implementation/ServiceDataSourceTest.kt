package ltd.ucode.panopticon.data.datasources.implementation

import ltd.ucode.panopticon.objectmothers.NetworkPictureMother
import ltd.ucode.panopticon.core.data.Result
import ltd.ucode.panopticon.data.datasources.implementation.client.PicSumClient
import ltd.ucode.panopticon.data.datasources.implementation.client.ServiceError
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test


@ExperimentalCoroutinesApi
class ServiceDataSourceTest {

    private val picSumClient: PicSumClient = mockk()
    private val serviceDataSource: ServiceDataSource = ServiceDataSource(picSumClient)

    @Test
    fun `get picture on client result is success`() = runBlockingTest {

        //Given
        val pictures = NetworkPictureMother.pictures()
        coEvery { picSumClient.fetchList() } returns Result.success(pictures)
        //When
        val result = serviceDataSource.getPictures()
        //Then
        assertThat(result, IsEqual(pictures))
        coVerify { picSumClient.fetchList() }
    }

    @Test
    fun `get picture on client result is fail`() = runBlockingTest {
        //Given
        val failure = Result.failure(ServiceError("test case on fail"))
        coEvery { picSumClient.fetchList() } returns failure
        //When
        val result = serviceDataSource.getPictures()
        //Then
        assertThat(result, IsEqual(emptyList()))
        coVerify { picSumClient.fetchList() }
    }
}
